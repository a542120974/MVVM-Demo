package com.example.databindingdemo.request;

import com.example.databindingdemo.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

public class RequestManager {

    private static final RequestManager REQUEST_MANAGER = new RequestManager();

    private RequestManager() {
    }

    public static RequestManager getInstance() {
        return REQUEST_MANAGER;
    }

    public void getList(DataResult<List<ListBean>> result) {
        List<ListBean> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            ListBean bean = new ListBean();
            bean.setText(i + "");
            list.add(bean);
        }
        result.onResult(list);
    }
}
