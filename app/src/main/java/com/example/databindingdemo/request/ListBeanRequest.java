package com.example.databindingdemo.request;

import com.example.databindingdemo.bean.ListBean;

import java.util.List;

public class ListBeanRequest {

    public void request(DataResult<List<ListBean>> result) {
        RequestManager.getInstance().getList(result);
    }
}
