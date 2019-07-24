package com.example.myapplication.工厂模式;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/23 0023
 *
 */
public class YellowHuman implements Human {
    private static final String TAG = "YELLO";

    @Override
    public void getColor() {
        System.out.println("getColor: " + "黄色");
    }

    @Override
    public void talk() {
        System.out.println("getColor: " + "汉语");
    }
}
