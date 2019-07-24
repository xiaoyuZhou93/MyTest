package com.example.myapplication.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/***
 *
 * @Author: Zhou xiaoyu
 * @CreateDate: 2019/7/22 0022
 *
 */
public  interface RetrointerService {

    @GET("ads")
    Call<ResponseBody> getAds();
}
