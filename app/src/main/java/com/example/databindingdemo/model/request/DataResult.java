package com.example.databindingdemo.model.request;

public interface DataResult<T> {

    void onResult(T t);
}
