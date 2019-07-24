package com.example.myapplication.抽象工厂;

/**
 * 产品等级1的实现类
 */
public class Creator1 extends AbstractCreator {
    //只生产产品等级为1的A产品
    public AbstractProductA createProductA() {
        return new ProductA();
    }

    // 只生产产品等级为1的B产品
    public AbstractProductB createProductB() {
        return new ProductB();
    }
}