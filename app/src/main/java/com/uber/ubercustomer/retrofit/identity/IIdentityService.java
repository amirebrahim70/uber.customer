package com.uber.ubercustomer.retrofit.identity;

import com.uber.ubercustomer.retrofit.identity.dtos.Login;
import com.uber.ubercustomer.retrofit.identity.dtos.LoginResult;
import com.uber.ubercustomer.retrofit.identity.dtos.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IIdentityService {
    @POST("login")
    Call<LoginResult> Login(@Body Login login);

    @POST("register")
    Call<Void> Register(@Body Register register);

}
