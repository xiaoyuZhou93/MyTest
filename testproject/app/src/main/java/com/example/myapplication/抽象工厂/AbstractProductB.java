package com.example.myapplication.抽象工厂;

/**
 * 抽象出来产品B
 */
public abstract class AbstractProductB {
    //每个产品共有的方法
    public void shareMethod() {
    }
    //每个产品相同方法，不同实现
    public abstract void doSomething();
}