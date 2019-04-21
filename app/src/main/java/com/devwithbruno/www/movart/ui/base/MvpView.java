package com.devwithbruno.www.movart.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Bruno on 15/01/2018.
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();


}

