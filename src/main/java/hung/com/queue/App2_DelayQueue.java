package hung.com.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue đc dùng bởi ScheduledThreadPoolExecutor
 * DelayQueue lại dùng PriorityQueue kết hợp với check điều kiện Expire .getDelay()
 * -----
 * PriorityQueue, DelayQueue nhỏ hơn sẽ lên đầu (trên đỉnh)
 */
public class App2_DelayQueue {
    private static final Logger log = LogManager.getLogger();

    public static class MyDelayedTask implements Delayed  {
        public long deadlineMillis;
        public MyDelayedTask(long delay, TimeUnit unit) {
            deadlineMillis = System.currentTimeMillis() + delay * unit.toMillis(1);
            log.debug(deadlineMillis);
        }

        /**
         * STEP 3: getDelay()
         * Jump code DelayQueue sẽ thấy:
         * getDelay() dùng cho mục đích check expire
         * .poll() chỉ lấy giá trị từ đỉnh Heap nếu expire tức: getDelay(TimeUnit.NANO) <= 0
         * nếu đỉnh Heap chưa expire nó sẽ trả về NULL ngay lập tức mà ko wait
         */
        @Override
        public long getDelay(TimeUnit unit) {
            long delayMillis =  (deadlineMillis - System.currentTimeMillis());
            // kiểm tra xem DelayQueue gọi hàm này khi nào
            log.debug("getDelay():  deadline = {}, delayMillis = {}", deadlineMillis, delayMillis );

            return delayMillis * TimeUnit.MILLISECONDS.toNanos(1)/unit.toNanos(1);
        }

        /**
         * STEP 2: PriorityQueue
         * PriorityQueue sẽ vun đống Heap theo .compareTo()
         * giải thuật vun đống giống với java Timer, cũng dùng Array để vun đống
         * giá trị compare ko phải là DelayTime, mà do ta định ở đây là deadlineTime
         * ---
         * PriorityQueue.offer() sẽ add từ cuối Array và vun đống
         * PriorityQueue.poll() sẽ lấy từ đỉnh Heap là Min, sau đó lấy phần tử cuối lên đầu rồi vun đống lại nhánh đó
         */
        @Override
        public int compareTo(Delayed o) {
            if( this.deadlineMillis > ((MyDelayedTask)o).deadlineMillis){
                return 1;
            }else if(this.deadlineMillis < ((MyDelayedTask)o).deadlineMillis){
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * STEP 1: create DelayQueue
         * DelayQueue: là implement của blockingQueue vì thế hỗ trợ multi-thread
         * -----
         * DelayQueue<E extends Delayed>
         * DelayQueue chứa 1 PriorityQueue dùng giải thuật Heap giống timer (Min ở đỉnh)
         * Heap theo hàm .compareTo() do ta implement
         * DelayQueue.poll() chỉ trả về giá trị Min ở đỉnh Heap khi E.getDelay() <= 0 tức là expire
         * DelayQueue.poll() sẽ trả về luôn NULL nếu đỉnh Heap chưa expire (ko đợi)
         * tức là E.getDelay() sẽ liên tục đc tính toán lại theo CurrentTime mỗi lần .poll()
         * ------
         * DelayQueue.poll() là kết hợp của PriorityQueue.peek() và check điều kiện E.getDelay() < 0
         * PriorityQueue.peek(): lấy giá trị từ đỉnh, nhưng ko remove
         * PriorityQueue.poll(): lấy giá trị từ đỉnh về và remove đỉnh. Sau đó vun đống lại
         *
         */
        BlockingQueue<MyDelayedTask> blockingQueue = new DelayQueue<MyDelayedTask>();


        blockingQueue.offer(new MyDelayedTask(50, TimeUnit.MILLISECONDS));
        Thread.sleep(10);
        blockingQueue.offer(new MyDelayedTask(50, TimeUnit.MILLISECONDS));
        Thread.sleep(10);
        blockingQueue.offer(new MyDelayedTask(50, TimeUnit.MILLISECONDS));

        System.out.println("=================== Heap ");
        int counter = 0;
        /**
         * kiểm tra xem có đúng .poll() nó lấy từ đỉnh Heap là Min hay ko
         */
        while(true){
            if(counter == 3){
                break;
            }
            log.debug("************** poll(): ");
            MyDelayedTask task = blockingQueue.poll();
            if(task == null){
                log.debug("task: null");
            }else{
                log.debug(" task: deadlineMillis = {} ", task.deadlineMillis);
                counter++;
            }
            Thread.sleep(10);
        }

    }
}
