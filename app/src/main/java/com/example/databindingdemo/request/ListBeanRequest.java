package com.example.databindingdemo.request;

import androidx.lifecycle.MutableLiveData;

import com.example.databindingdemo.bean.ListBean;

import java.util.List;

public class ListBeanRequest {

    public void request(MutableLiveData<List<ListBean>> listLiveData) {
        RequestManager.getInstance().getList(listLiveData::setValue);
    }
}
