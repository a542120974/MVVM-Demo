package com.example.databindingdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.library.baseAdapters.BR;

import com.example.databindingdemo.R;
import com.example.databindingdemo.base.BaseActivity;
import com.example.databindingdemo.ui.viewmodel.EventViewModel;
import com.example.databindingdemo.ui.viewmodel.SecondViewModel;
import com.example.databindingdemo.utils.DataBindingConfig;

public class SecondActivity extends BaseActivity {

    private EventViewModel eventViewModel;
    private SecondViewModel secondViewModel;

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_second, BR.vm, secondViewModel)
                .addBindingParam(BR.click, new Click());
    }

    @Override
    protected void initViewModel() {
        secondViewModel = getActivityViewModel(SecondViewModel.class);
        eventViewModel =  EventViewModel.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventViewModel.clickText.observe(this, s -> System.out.println("second change"));
    }

    public class Click {

        public void click() {
            eventViewModel.clickText.setValue("click");
        }
    }

    public static void startMe(Context context) {
        Intent i = new Intent(context, SecondActivity.class);
        context.startActivity(i);
    }
}