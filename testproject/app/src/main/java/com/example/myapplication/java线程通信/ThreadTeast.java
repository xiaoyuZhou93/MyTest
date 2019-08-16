package com.example.myapplication.java线程通信;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/30 0030
 *
 */
public class ThreadTeast {
    public static void main(String[] args) {
        new MyThread("MAX_PRIORITY", Thread.MAX_PRIORITY).start();
        new MyThread("MIN_PRIORITY", Thread.MIN_PRIORITY).start();
        new MyThread("NORM_PRIORITY", Thread.NORM_PRIORITY).start();

    }
}
