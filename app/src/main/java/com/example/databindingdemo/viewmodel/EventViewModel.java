package com.example.databindingdemo.viewmodel;

import androidx.lifecycle.ViewModel;

import com.kunminx.architecture.ui.callback.UnPeekLiveData;

/**
 * 使用单例ViewModel，断开lifecycle生命周期结束自调clear，用于页面之间通信
 */
public class EventViewModel extends ViewModel {

    private static EventViewModel INSTANCE = null;

    public static final UnPeekLiveData<Boolean> test =
            new UnPeekLiveData.Builder<Boolean>().setEventSurvivalTime(500).create();

    public UnPeekLiveData<String> clickText = new UnPeekLiveData<>();

    private EventViewModel() {
    }

    public static EventViewModel getInstance() {
        if (INSTANCE == null)
            INSTANCE = new EventViewModel();
        return INSTANCE;
    }
}
