package com.uber.ubercustomer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.uber.ubercustomer.R;
import com.uber.ubercustomer.tools.IActivityBase;
import com.uber.ubercustomer.tools.ILoadingDialog;

public class RegisterActivity extends AppCompatActivity implements IActivityBase, ILoadingDialog {

    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViewRefrences();
        initViewActions();
        initInitialValues();
    }

    @Override
    public void initViewRefrences() {

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