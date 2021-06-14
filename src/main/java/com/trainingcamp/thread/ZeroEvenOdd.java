package com.trainingcamp.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    private Semaphore zero = new Semaphore(1);
    /**
     * 偶数
     */
    private Semaphore even = new Semaphore(0);
    /**
     * 奇数
     */
    private Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    /**
     * printNumber.accept(x) outputs "x", where x is an integer.
     */
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}