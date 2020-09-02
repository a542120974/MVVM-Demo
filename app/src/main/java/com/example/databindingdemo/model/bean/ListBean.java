package com.example.databindingdemo.model.bean;

public class ListBean {

    public ListBean() {
    }

    public ListBean(String txt) {
        text = txt;
    }

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
