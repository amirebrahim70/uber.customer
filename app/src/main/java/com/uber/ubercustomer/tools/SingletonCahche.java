package com.uber.ubercustomer.tools;

public class SingletonCahche {
    private  SingletonCahche(){}
    private static SingletonCahche instance;
    public static synchronized SingletonCahche getInstance() {
        if (instance == null) {
            instance = new SingletonCahche();
        }
        return instance;
    }

    private String accessToken;
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    ////////////////////////////////////
    private String currnetUsername;

    public String getCurrnetUsername() {
        return currnetUsername;
    }

    public void setCurrnetUsername(String currnetUsernae) {
        this.currnetUsername = currnetUsernae;
    }
}
