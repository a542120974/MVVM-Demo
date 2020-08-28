package com.example.databindingdemo.utils;

import android.util.SparseArray;

import androidx.lifecycle.ViewModel;

public class DataBindingConfig {

    private int layout;

    private int vmVariableId;

    private ViewModel viewModel;

    private SparseArray<Object> bindingParams = new SparseArray<>();

    public DataBindingConfig(int layout, int vmVariableId, ViewModel viewModel) {
        this.layout = layout;
        this.vmVariableId = vmVariableId;
        this.viewModel = viewModel;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    public int getVmVariableId() {
        return vmVariableId;
    }

    public int getLayout() {
        return layout;
    }

    public SparseArray<Object> getBindingParams() {
        return bindingParams;
    }

    public DataBindingConfig addBindingParam(int variableId, Object object) {
        if (bindingParams.get(variableId) == null) {
            bindingParams.put(variableId, object);
        }
        return this;
    }
}
