package com.example.databindingdemo.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

public class BaseApplication extends Application implements ViewModelStoreOwner {

    private ViewModelStore viewModelStore;

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        if (viewModelStore == null)
            viewModelStore = new ViewModelStore();
        return viewModelStore;
    }
}
