package com.example.databindingdemo;

import android.os.Bundle;
import android.widget.Toast;

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
            new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    List<ListBean> li = new ArrayList<>();
                    for (int i = 0; i < 15; i++) {
                        li.add(new ListBean("11" + i));
                    }

                    viewModel.data.postValue(li);
                }
            }.start();

            Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
        }

        public void toast2() {
            List<ListBean> li = viewModel.data.getValue();

            if (li != null) {
                li.get(0).setText("ssssssssss");
            }

            viewModel.data.setValue(li);
            viewModel.notify.setValue(true);
            Toast.makeText(getApplicationContext(), "change item", Toast.LENGTH_SHORT).show();
        }
    }
}