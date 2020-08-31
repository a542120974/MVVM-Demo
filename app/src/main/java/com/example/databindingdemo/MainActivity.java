package com.example.databindingdemo;

import android.os.Bundle;
import android.widget.Toast;

import com.example.databindingdemo.adapter.ListAdapter;
import com.example.databindingdemo.base.BaseActivity;
import com.example.databindingdemo.bean.ListBean;
import com.example.databindingdemo.model.ListBeanViewModel;
import com.example.databindingdemo.request.DataResult;
import com.example.databindingdemo.utils.DataBindingConfig;

import java.util.List;

public class MainActivity extends BaseActivity {

    private ListBeanViewModel viewModel;

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.vm, viewModel)
                .addBindingParam(BR.click, new Click())
                .addBindingParam(BR.adapter, new ListAdapter(this));
    }

    @Override
    protected void initViewModel() {
        viewModel = new ListBeanViewModel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel.request.request(listBeans -> viewModel.data.setValue(listBeans));
        viewModel.notify.setValue(true);
    }

    public class Click {

        public void toast() {
            Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
        }
    }
}