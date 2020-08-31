package com.example.databindingdemo.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.databindingdemo.bean.ListBean;
import com.example.databindingdemo.request.RequestManager;

import java.util.List;

/**
 * 业务逻辑处理层
 */
public class ListBeanRepository {

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
