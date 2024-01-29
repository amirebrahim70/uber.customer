package com.uber.ubercustomer.retrofit.identity.dtos;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    public Login(String email,String password){
        this.email = email;
        this.password = password;
    }
}
