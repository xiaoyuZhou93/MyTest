package com.example.myapplication.retrofit;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/22 0022
 *
 */
public class RetrofitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        initRetrofit();
        initRetrofit2();
    }

    private void initRetrofit2() {
        Gson gson = new GsonBuilder()
                //配置你的Gson
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("www.baidu")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrointerService retrofit1 = retrofit.create(RetrointerService.class);
        retrofit1.getAds().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    static void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("www.baidu.com")
                .build();
        BlogService service = retrofit.create(BlogService.class);
        Call<ResponseBody> call = service.getBlog(2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
