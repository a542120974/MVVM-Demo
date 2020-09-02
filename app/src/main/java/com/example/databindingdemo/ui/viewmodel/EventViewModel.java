package com.example.databindingdemo.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 用于页面之间通信
 */
public class EventViewModel extends ViewModel {

    private static EventViewModel INSTANCE = null;

    public MutableLiveData<String> clickText = new MutableLiveData<>();

    private EventViewModel() {
    }

    public static EventViewModel getInstance() {
        if (INSTANCE == null)
            INSTANCE = new EventViewModel();
        return INSTANCE;
    }
}
