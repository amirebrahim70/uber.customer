package com.uber.ubercustomer.retrofit.identity.dtos;

public class Register {
    public String email;

    public String password;

    public Register(String email,String password){
        this.email = email;
        this.password = password;
    }
}
