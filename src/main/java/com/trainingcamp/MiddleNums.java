package com.trainingcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生成10亿个1到1000万的数字，然后求出来中位数
 * 考点:什么是中位数？中位数怎么求？怎么随机生成数字？大量数字排序怎么做
 *
 * @author jiaming
 */
public class MiddleNums implements Runnable {

    /**
     * 大顶堆：存放较小数字的一半，堆顶为最小数字一半的最大元素
     */
    private PriorityQueue<Integer> maxHeap;
    /**
     * 小顶堆：存放较大数字的一半，堆顶为最大数字一半的最小元素
     */
    private PriorityQueue<Integer> minHeap;

    private static final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1000 * 100);

    private static final int totalNums = 100 * 1000 * 1000;

    /**
     * 生成的数字总数
     */
    private static final AtomicInteger totalNumsAtomic = new AtomicInteger(totalNums);

    private static final AtomicInteger counter = new AtomicInteger(0);

    public MiddleNums() {
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        minHeap = new PriorityQueue<>();
    }

    /**
     * 添加元素进堆中
     *
     * @param num
     */
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        //保持平衡，调整堆大小
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    /**
     * 计算中位数，需要考虑基数和偶数的情况
     *
     * @return List
     */
    public List<Integer> findMiddleNum() {
        if (counter.get() == totalNums) {
            List<Integer> res = new ArrayList<>();
            if (maxHeap.size() == minHeap.size()) {
                res.add(maxHeap.peek());
            }
            res.add(minHeap.peek());
            return res;
        }
        return null;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer num = blockingQueue.take();
                addNum(num);
                if (counter.incrementAndGet() == totalNums) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成1亿个1-1000w的数字
     */
    static class Generator implements Runnable {
        private Random random = new Random();

        @Override
        public void run() {
            while (true) {
                if (totalNumsAtomic.decrementAndGet() >= 0) {
                    int num = random.nextInt(totalNums);
                    if (num <= 0) {
                        totalNumsAtomic.incrementAndGet();
                        continue;
                    }
                    //System.out.println("generator nums: " + num);
                    try {
                        blockingQueue.put(num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        MiddleNums middleNums = new MiddleNums();
        Generator generator = new Generator();
        Thread t1 = new Thread(generator);
        Thread t2 = new Thread(generator);
        Thread t3 = new Thread(generator);
        Thread t4 = new Thread(generator);
        Thread sortThread = new Thread(middleNums);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        sortThread.start();
        //等待结果
        while (true) {
            List<Integer> middleNum = middleNums.findMiddleNum();
            if (middleNum != null && !middleNum.isEmpty()) {
                System.out.println(middleNum);
                break;
            } else {
                Thread.sleep(100);
            }
        }
        System.out.println("cost:" + (System.currentTimeMillis() - beginTime));
    }

}
