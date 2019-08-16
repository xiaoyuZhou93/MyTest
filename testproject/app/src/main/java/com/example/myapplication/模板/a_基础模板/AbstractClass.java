package com.example.myapplication.模板.a_基础模板;

public abstract class AbstractClass {
    //基本方法
    protected abstract void doSomething();
//    基本方法
    protected abstract void doAnything();


//    模板方法
    public void templateMethod() {
        // 调用基本方法，完成相关的逻辑
        this.doAnything();
        this.doSomething();
    }
}
