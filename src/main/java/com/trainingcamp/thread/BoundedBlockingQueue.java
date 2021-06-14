package com.trainingcamp.thread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列
 *
 * @author jiaming
 */
public class BoundedBlockingQueue {

    private volatile int capacity;

    private AtomicInteger size = new AtomicInteger(0);
    private LinkedList<Integer> container;

    private static final ReentrantLock lock = new ReentrantLock();

    private Condition producer = lock.newCondition();

    private Condition consumer = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        container = new LinkedList<>();
    }

    public void enqueue(int e) throws InterruptedException {
        lock.lock();
        try {
            while (size.get() >= capacity) {
                producer.await();
            }
            container.addFirst(e);
            size.incrementAndGet();
            consumer.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size.get() == 0) {
                consumer.await();
            }
            int value = container.removeLast();
            size.decrementAndGet();
            producer.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return size.get();
        } finally {
            lock.unlock();
        }
    }

}