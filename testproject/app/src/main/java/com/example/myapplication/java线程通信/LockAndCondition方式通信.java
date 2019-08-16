package com.example.myapplication.java线程通信;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 *   不需要使用synchronized
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/30 0030
 *
 */
public class LockAndCondition方式通信 {
    public static void main(String[] args) {
        Resource r = new Resource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        Thread t1 = new Thread(pro);
        Thread t3 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t4 = new Thread(con);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    static class Resource {
        private String name;
        private int count = 1;
        private boolean flag = false;
        private Lock lock = new ReentrantLock();/*Lock是一个接口，ReentrantLock是该接口的一个直接子类。*/
        private Condition condition_pro = lock.newCondition(); /*创建代表生产者方面的Condition对象*/
        private Condition condition_con = lock.newCondition(); /*使用同一个锁，创建代表消费者方面的Condition对象*/

        public void set(String name) {
            lock.lock();//锁住此语句与lock.unlock()之间的代码
            try {
                while (flag)
                    condition_pro.await(); //生产者线程在conndition_pro对象上等待
                this.name = name + "---" + count++;
                System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
                flag = true;
                condition_con.signalAll();/*唤醒所有在condition_con对象下等待的线程，也就是唤醒所有消费者线程*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); //unlock()要放在finally块中。
            }
        }

        public void out() {
            lock.lock(); //锁住此语句与lock.unlock()之间的代码
            try {
                while (!flag)
                    condition_con.await(); //消费者线程在conndition_con对象上等待
                System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
                flag = false;
                condition_pro.signalAll(); /*唤醒所有在condition_pro对象下等待的线程，也就是唤醒所有生产者线程*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 生产
     */
    static class Producer implements Runnable {
        private Resource res;

        Producer(Resource res) {
            this.res = res;
        }

        public void run() {
            while (true) {
                res.set("商品");
            }
        }
    }

    /**
     * 消费
     */
    static class Consumer implements Runnable {
        private Resource res;

        Consumer(Resource res) {
            this.res = res;
        }

        public void run() {
            while (true) {
                res.out();
            }
        }
    }


}