package com.example.phuc.quanlybo.service;

import com.example.phuc.quanlybo.model.UserDetail;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by phuc on 04/04/2016.
 */
public interface QuanlyService {

    @FormUrlEncoded
    @POST("user/api/login")
    Call<UserDetail> getUserLogin(
             @Field("phoneNumber") String  phoneNumber,
             @Field("password") String  password);
}
