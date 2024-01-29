package com.uber.ubercustomer.retrofit.identity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IdentityServiceBuilder {
    public IIdentityService getService() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain
                        .request()
                        .newBuilder()
                        //.addHeader("parameter", "value")
                        .build();
                return chain.proceed(request);
            }
        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myuber.ir/identity/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        IIdentityService service = retrofit.create(IIdentityService.class);
        return service;
    }
}
