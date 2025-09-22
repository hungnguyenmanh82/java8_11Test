package hung.com.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Giải thuật vun đống Heap Variant của PriorityQueue giống java timer dùng Array để vun đống
 * Nó có nhược điểm của BinaryTree là ko làm việc đồng thời với MultiThread đc
 * Khi 1 thread read/write thì các thread khác sẽ bị block lại
 * Vun đống trên Array có nhược điểm là số lệnh Swap khá nhiều (tức write nhiều) nên performance ko tốt
 * -----
 * Java Timer, Schedule đang dùng giải thuật này nên sẽ gặp vấn đề với multi-thread
 * -----
 * PriorityQueue, DelayQueue nhỏ hơn sẽ lên đầu (trên đỉnh)
 */
public class App1_PriorityQueue {
    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {

        /**
         * PriorityQueue/PriorityBlockingQueue: là Array Heap sort (giải thuật vun đống), đỉnh là Min
         * dùng chính hàm Object.comparatorTo() để so sánh tìm Min cho vun đống
         * giải thuật giống hệt java timer.
         * ------
         * PriorityQueue.offer() sẽ add từ cuối Array và vun đống
         * PriorityQueue.poll() sẽ lấy từ đỉnh Heap là Min, sau đó lấy phần tử cuối lên đầu rồi vun đống lại nhánh đó
         * peek: lấy từ đỉnh queue, nhưng ko remove phần tử đó khỏi queue
         * -------
         * có thể thay Integer bằng Class extend Comparable
         * vd: class HuffmanNode implements Comparable<HuffmanNode>{}
         * PriorityQueue cần dựa vào Comparable để so sánh
         */
        Queue<Integer> queue = new PriorityQueue<Integer>();


        /**
         * offer()/offer(TimeOut): synchronous add to Queue (queue full thì sẽ đợi)
         * poll()/poll(TimeOut): synchronous get + remove = get from Queue
         * peek: lấy từ đỉnh queue, nhưng ko remove phần tử đó khỏi queue
         * ----
         * add nhiều phần tử để xem nó vun đống (Heap sort) thế nào
         */
        queue.offer(3);
        queue.offer(1);
        queue.offer(5);

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            log.debug(queue.poll());
        }

    }
}
