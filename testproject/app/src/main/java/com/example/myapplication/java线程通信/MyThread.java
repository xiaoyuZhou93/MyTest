package com.example.myapplication.java线程通信;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/30 0030
 *
 */
public class MyThread extends Thread {


    public MyThread(String name ,int pro) {
        super(name);
        setPriority(pro);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + "线程第" + i + "次执行！");
        }
        this.stop();
    }
}
