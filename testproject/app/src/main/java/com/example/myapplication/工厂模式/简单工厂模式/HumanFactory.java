package com.example.myapplication.工厂模式.简单工厂模式;

import com.example.myapplication.工厂模式.Human;

/***
 *  生产人的工厂
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/23 0023
 *
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        //定义一个生产的人种
        System.out.println(c);
        Human human = null;
        try {
            // 产生一个人种
            human = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人种生成错误！");
        }
        return (T) human;
    }


//    等同于上面抽象类实现的方法  (简单的工厂类)
    public static <T extends Human> T createman(Class<T> c) {
        //定义一个生产的人种
        System.out.println(c);
        Human human = null;
        try {
            // 产生一个人种
            human = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人种生成错误！");
        }
        return (T) human;
    }

}
//     说明 : 给你一个字符串变量，它代表一个类的包名和类名，你怎么实例化它？
//     A a = (A)Class.forName("pacage.A").newInstance();
//     这和你
//     A a = new A()；
//     是一样的效果。
