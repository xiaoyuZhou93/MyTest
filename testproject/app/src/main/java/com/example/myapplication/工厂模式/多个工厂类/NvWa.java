package com.example.myapplication.工厂模式.多个工厂类;

import com.example.myapplication.工厂模式.BlackHuman;
import com.example.myapplication.工厂模式.Human;
import com.example.myapplication.工厂模式.WhiteHuman;
import com.example.myapplication.工厂模式.YellowHuman;
import com.example.myapplication.工厂模式.简单工厂模式.AbstractHumanFactory;
import com.example.myapplication.工厂模式.简单工厂模式.HumanFactory;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/23 0023
 *
 */
public class NvWa {
    public static void main(String[] args) {

//        升级为多个工厂的模式
//        女娲第一次造人，火候不足，于是白色人种产生了
        System.out.println("--造出的第一批人是白色人种--");
        Human whiteHuman = (new WhiteHumanFactory()).createHuman();
        whiteHuman.getColor();
        whiteHuman.talk();
//         女娲第二次造人，火候过足，于是黑色人种产生了
        System.out.println("\n--造出的第二批人是黑色人种--");
        Human blackHuman = (new BlackHumanFactory()).createHuman();
        blackHuman.getColor();
        blackHuman.talk();
//         第三次造人，火候刚刚好，于是黄色人种产生了
        System.out.println("\n--造出的第三批人是黄色人种--");
        Human yellowHuman = (new YellowHumanFactory()).createHuman();
        yellowHuman.getColor();
        yellowHuman.talk();


    }
}
