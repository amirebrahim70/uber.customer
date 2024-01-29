package com.uber.ubercustomer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.uber.ubercustomer.R;
import com.uber.ubercustomer.retrofit.identity.IIdentityService;
import com.uber.ubercustomer.retrofit.identity.IdentityServiceBuilder;
import com.uber.ubercustomer.tools.IActivityBase;
import com.uber.ubercustomer.tools.ILoadingDialog;

import java.nio.file.SecureDirectoryStream;

public class LoginActivity extends AppCompatActivity implements IActivityBase, ILoadingDialog {

    private ProgressDialog dialog;
    private IIdentityService identityService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViewRefrences();
        initViewActions();
        initInitialValues();
    }

    @Override
    public void initViewRefrences() {
        identityService = new IdentityServiceBuilder().getService();
    }

    @Override
    public void initViewActions() {

    }

    @Override
    public void initInitialValues() {

    }

    @Override
    public ProgressDialog showProgressbar() {
        dialog = ProgressDialog.show(this,"","Please Wait",true);
        return  dialog;
    }

    @Override
    public void hideProgress() {
        dialog.cancel();
    }
}