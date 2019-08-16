package com.example.myapplication.java线程通信;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/30 0030
 *
 */
public class 多个消费者通信 {

    public static void main(String[] args) {
        Resource r=new Resource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        Thread t1 = new Thread(pro);
        Thread t3 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t4 = new Thread(con);
        t1.start();
        t3.start();
        t2.start();
        t4.start();
    }

    static class Resource {
        private String name;
        private int count = 1;
        private boolean flag = false;

        public synchronized void set(String name) {
            while (flag) /*原先是if,现在改成while，这样生产者线程从冻结状态醒来时，还会再判断flag.*/
                try {
                    wait(); //在这里等待 唤醒也是从这里开始执行
                } catch (Exception e) {
                }
            this.name = name + "---" + count++;
            System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
            flag = true;
            this.notifyAll();/*原先是notity(), 现在改成notifyAll(),这样生产者线程生产完一个商品后可以将等待中的消费者线程唤醒，否则只将上面改成while后，可能出现所有生产者和消费者都在wait()的情况。*/
        }
        public synchronized void out() {

            while (!flag) /*原先是if,现在改成while，这样消费者线程从冻结状态醒来时，还会再判断flag.*/
                try {
                    wait();
                } catch (Exception e) {
                }
            System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
            flag = false;
            this.notifyAll(); /*原先是notity(), 现在改成notifyAll(),这样消费者线程消费完一个商品后可以将等待中的生产者线程唤醒，否则只将上面改成while后，可能出现所有生产者和消费者都在wait()的情况。*/
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
