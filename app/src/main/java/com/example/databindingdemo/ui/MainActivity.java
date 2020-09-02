package com.example.databindingdemo.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.databindingdemo.BR;
import com.example.databindingdemo.R;
import com.example.databindingdemo.base.BaseActivity;
import com.example.databindingdemo.model.bean.ListBean;
import com.example.databindingdemo.ui.adapter.ListAdapter;
import com.example.databindingdemo.ui.viewmodel.EventViewModel;
import com.example.databindingdemo.ui.viewmodel.ListBeanViewModel;
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
                .addBindingParam(BR.event_vm, eventViewModel)
                .addBindingParam(BR.adapter, new ListAdapter(this));
    }

    @Override
    protected void initViewModel() {
        viewModel = getActivityViewModel(ListBeanViewModel.class);
        eventViewModel = EventViewModel.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel.request.getLiveData().observe(this, listBeans -> {
            viewModel.data.setValue(listBeans);
            viewModel.notify.setValue(true);
        });

        eventViewModel.clickText.observe(this, s -> {
            System.out.println("main observe");
            Toast.makeText(MainActivity.this, "change", Toast.LENGTH_SHORT).show();
        });

        viewModel.request.request();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(eventViewModel.clickText.getValue())) {
            System.out.println("event text null");
        } else {
            System.out.println(eventViewModel.clickText.getValue());
        }
    }

    public class Click {

        public void click1() {
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
                    viewModel.notify.setValue(true);
                }
            }.start();

            Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
        }

        public void click2() {
            List<ListBean> li = viewModel.data.getValue();

            if (li != null) {
                li.get(0).setText("ssssssssss");
            }

            viewModel.data.setValue(li);
            viewModel.notify.setValue(true);
            Toast.makeText(getApplicationContext(), "change item", Toast.LENGTH_SHORT).show();
        }

        public void click3() {
            SecondActivity.startMe(MainActivity.this);
        }
    }
}