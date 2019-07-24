package com.example.myapplication.工厂模式.简单工厂模式;

import com.example.myapplication.工厂模式.Human;

/**
 * 烧人的炉子
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}