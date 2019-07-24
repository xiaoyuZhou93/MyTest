package com.example.myapplication.工厂模式.多个工厂类;

import com.example.myapplication.工厂模式.Human;
import com.example.myapplication.工厂模式.BlackHuman;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/23 0023
 *
 */
public class BlackHumanFactory extends AbstractHumanFactory2{
    @Override
    public Human createHuman() {
        return new BlackHuman();
    }
}
