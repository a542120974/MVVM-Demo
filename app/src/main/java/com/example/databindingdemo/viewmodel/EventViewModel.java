package com.example.databindingdemo.viewmodel;

import androidx.lifecycle.ViewModel;

import com.kunminx.architecture.ui.callback.UnPeekLiveData;

/**
 * 用于页面之间通信
 */
public class EventViewModel extends ViewModel {

    private static EventViewModel INSTANCE = null;

    public UnPeekLiveData<String> clickText = new UnPeekLiveData<>();

    private EventViewModel() {
    }

    public static EventViewModel getInstance() {
        if (INSTANCE == null)
            INSTANCE = new EventViewModel();
        return INSTANCE;
    }
}
