package com.example.databindingdemo.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.databindingdemo.bean.ListBean;
import com.example.databindingdemo.repository.ListBeanRepository;

import java.util.List;

public class ListBeanViewModel extends ViewModel {

    public MutableLiveData<Boolean> notify = new MutableLiveData<>();

    public MutableLiveData<List<ListBean>> data = new MutableLiveData<>();

    public ListBeanRepository request = new ListBeanRepository();

}
