package com.example.databindingdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.databindingdemo.adapter.ListAdapter;
import com.example.databindingdemo.base.BaseActivity;
import com.example.databindingdemo.bean.ListBean;
import com.example.databindingdemo.model.EventViewModel;
import com.example.databindingdemo.model.ListBeanViewModel;
import com.example.databindingdemo.utils.DataBindingConfig;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ListBeanViewModel viewModel;
    private EventViewModel eventViewModel;

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.vm, viewModel)
                .addBindingParam(BR.click, new Click())
                .addBindingParam(BR.adapter, new ListAdapter(this));
    }

    @Override
    protected void initViewModel() {
        viewModel = getActivityViewModel(ListBeanViewModel.class);
        eventViewModel = getAppViewModel(EventViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel.request.getLiveData().observe(this, listBeans -> viewModel.data.setValue(listBeans));

        viewModel.request.request();
    }

    public class Click {

        public void toast1() {
            List<ListBean> li = new ArrayList<>();
            li.add(new ListBean("1111"));
            li.add(new ListBean("222"));
            li.add(new ListBean("333"));
            li.add(new ListBean("444"));
            li.add(new ListBean("555"));
            li.add(new ListBean("666"));
            viewModel.data.setValue(li);
            Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
        }

        public void toast2() {
            List<ListBean> li = new ArrayList<>();
            li.add(new ListBean("aaa"));
            li.add(new ListBean("ssss"));
            li.add(new ListBean("dddd"));
            li.add(new ListBean("ffff"));
            li.add(new ListBean("ggg"));
            li.add(new ListBean("hhh"));
            viewModel.data.setValue(li);
            Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
        }
    }
}