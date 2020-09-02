package com.example.databindingdemo.request;

import com.example.databindingdemo.model.bean.ListBean;

import java.util.List;

public interface ResponseCallBackListBean {

    void getList(DataResult<List<ListBean>> result);
}
