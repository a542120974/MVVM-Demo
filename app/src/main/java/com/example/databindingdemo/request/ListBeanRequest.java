package com.example.databindingdemo.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.databindingdemo.bean.ListBean;

import java.util.List;

public class ListBeanRequest {

    private MutableLiveData<List<ListBean>> listLiveData;

    public LiveData<List<ListBean>> getLiveData() {
        if (listLiveData == null)
            listLiveData = new MutableLiveData<>();
        return listLiveData;
    }

    public void request() {
        RequestManager.getInstance().getList(listBeans -> listLiveData.setValue(listBeans));
    }
}
