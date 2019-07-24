package com.example.myapplication;

import android.util.Log;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public  void initView2() {
        final String TAG = "123123123";
        Observable.just(1, 2, 3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "=================onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "=================onNext " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "=================onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "=================onComplete ");
                    }
                });

    }


}