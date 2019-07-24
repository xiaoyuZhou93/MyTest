package com.example.myapplication.模板.b_具体实现;

import com.example.myapplication.模板.b_具体实现.HummerH1Model;
import com.example.myapplication.模板.b_具体实现.HummerH2Model;
import com.example.myapplication.模板.a_基础模板.AbstractClass;
import com.example.myapplication.模板.a_基础模板.ConcreteClass1;
import com.example.myapplication.模板.a_基础模板.ConcreteClass2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/24 0024
 *
 */
public class main {
    public static void main(String[] args) {


        System.out.println("-------H1型号悍马--------");
        System.out.println("H1型号的悍马是否需要喇叭声响？0-不需要   1-需要");
//        String type = (new BufferedReader(new InputStreamReader(System.in))).toString();
        String type = "0";
        HummerH1Model h1 = new HummerH1Model();
        if (type.equals("0")) {
            h1.setAlarm(true);
        }
        h1.run();
        System.out.println("\n-------H2型号悍马--------");
        HummerH2Model h2 = new HummerH2Model();
        h2.run();


    }
}
