package com.example.myapplication.单例模式;

/***
 *      双重锁单例
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/22 0022
 *
 */
public class SingleActivity {
    private static SingleActivity singleActivity = null;

    private SingleActivity() {

    }

    public SingleActivity getInstence() {
        if (singleActivity == null) {
            synchronized (SingleActivity.class) {
                if (singleActivity == null) {
                    singleActivity = new SingleActivity();
                }
            }
        }
        return singleActivity;
    }
}
