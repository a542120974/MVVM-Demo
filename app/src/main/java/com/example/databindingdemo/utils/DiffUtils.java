package com.example.databindingdemo.utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.databindingdemo.bean.ListBean;

public class DiffUtils {

    private DiffUtil.ItemCallback<ListBean> listBeanItemCallback;

    private static DiffUtils diffUtil = null;

    private DiffUtils() {
    }

    public DiffUtil.ItemCallback<ListBean> getListBeanItemCallback() {
        if (listBeanItemCallback == null)
            listBeanItemCallback = new DiffUtil.ItemCallback<ListBean>() {
                @Override
                public boolean areItemsTheSame(@NonNull ListBean oldItem, @NonNull ListBean newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull ListBean oldItem, @NonNull ListBean newItem) {
                    return oldItem.getText().equals(newItem.getText());
                }
            };
        return listBeanItemCallback;
    }

    public static DiffUtils getDiffUtil() {
        if (diffUtil == null)
            diffUtil = new DiffUtils();
        return diffUtil;
    }
}
