package com.example.databindingdemo.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

public class BaseApplication extends Application implements ViewModelStoreOwner {

    private ViewModelStore viewModelStore;

    @Override
    public void onCreate() {
        super.onCreate();
        viewModelStore = new ViewModelStore();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return viewModelStore;
    }
}
