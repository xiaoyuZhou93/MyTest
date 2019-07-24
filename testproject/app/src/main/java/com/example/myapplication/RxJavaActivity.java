package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/22 0022
 *
 */
public class RxJavaActivity extends AppCompatActivity {


    public static String TAG = "testststststs";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
//        initView();
        initView2();

    }

    private void initView2() {

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        })
        Observable.just(1, 2, 3)
                .doOnNext(new Consumer<Integer>() {  //发送next之前
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "==================doOnEach " + "doOnNext");
                    }
                })
                .doOnEach(new Consumer<Notification<Integer>>() { //每发送一件事件之前

                    @Override
                    public void accept(Notification<Integer> integerNotification) throws Exception {
                        Log.e(TAG, "==================doOnEach " + "doOnEach");
                    }
                })
                .doAfterNext(new Consumer<Integer>() { //发送next之后
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                })

                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "==================onSubscribe ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "==================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "==================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "==================onComplete ");
                    }
                });


    }

    private void initView() {
        //被观察者
        Observable<Object> observable = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {

            }
        });

        //观察者
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        //订阅
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);


    }
}

class testBean {
    private String namge;

    public String getNamge() {
        return namge;
    }

    public void setNamge(String namge) {
        this.namge = namge;
    }
}