package com.example.databindingdemo.model.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.databindingdemo.model.bean.ListBean;
import com.example.databindingdemo.model.request.RequestManagerListBean;

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
        RequestManagerListBean.getInstance().getList(listBeans -> listLiveData.setValue(listBeans));
    }
}
