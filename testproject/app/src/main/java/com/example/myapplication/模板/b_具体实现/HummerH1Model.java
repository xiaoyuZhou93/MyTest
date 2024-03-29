package com.example.myapplication.模板.b_具体实现;

public class HummerH1Model extends HummerModel {
    private boolean alarmFlag = true;
    // 要响喇叭

    protected void alarm() {
        System.out.println("悍马H1鸣笛...");
    }

    protected void engineBoom() {
        System.out.println("悍马H1引擎声音是这样的...");
    }

    protected void start() {
        System.out.println("悍马H1发动...");
//
    }

    protected void stop() {
        System.out.println("悍马H1停车...");
    }

    protected boolean isAlarm() {
        return this.alarmFlag;
    }
    //要不要响喇叭，是由客户来决定的
    public void setAlarm(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }
}