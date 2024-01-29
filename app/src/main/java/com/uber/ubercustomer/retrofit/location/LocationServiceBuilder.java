package com.uber.ubercustomer.retrofit.location;

import com.uber.ubercustomer.retrofit.identity.IIdentityService;
import com.uber.ubercustomer.tools.SingletonCahche;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationServiceBuilder {
    public ILocationService getService() {

        String accessToken = SingletonCahche.getInstance().getAccessToken();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain
                        .request()
                        .newBuilder()
                        .addHeader("Authorization", "Bearer "+accessToken)
                        .build();
                return chain.proceed(request);
            }
        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myuber.ir/location/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        ILocationService service = retrofit.create(ILocationService.class);
        return service;
    }

}
