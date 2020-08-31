package com.example.databindingdemo.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.databindingdemo.bean.ListBean;
import com.example.databindingdemo.request.ListBeanRequest;

import java.util.List;

public class ListBeanViewModel extends ViewModel {

    public MutableLiveData<List<ListBean>> data = new MutableLiveData<>();

    public ListBeanRequest request = new ListBeanRequest();

}
