package com.uber.ubercustomer.tools;

import android.app.ProgressDialog;

public interface ILoadingDialog {
    public ProgressDialog showProgressbar();
    public void hideProgress();
}
