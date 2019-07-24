package com.example.myapplication.工厂模式;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/23 0023
 *
 */
public class WhiteHuman implements Human {
    private static final String TAG ="white";

    @Override
    public void getColor() {
      System.out.println("getColor: "+"白色");
    }

    @Override
    public void talk() {
        System.out.println( "getColor: "+"英语");
    }
}
