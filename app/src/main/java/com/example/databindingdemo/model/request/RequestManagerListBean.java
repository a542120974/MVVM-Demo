package com.example.databindingdemo.model.request;

import com.example.databindingdemo.model.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

public class RequestManagerListBean implements ResponseCallBackListBean {

    private static final RequestManagerListBean REQUEST_MANAGER = new RequestManagerListBean();

    private RequestManagerListBean() {
    }

    public static RequestManagerListBean getInstance() {
        return REQUEST_MANAGER;
    }

    @Override
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
