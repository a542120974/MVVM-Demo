package com.example.databindingdemo.adapter;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.databindingdemo.R;
import com.example.databindingdemo.base.BaseDataBindingAdapter;
import com.example.databindingdemo.bean.ListBean;
import com.example.databindingdemo.databinding.ItemMainListBinding;
import com.example.databindingdemo.utils.DiffUtils;

public class ListAdapter extends BaseDataBindingAdapter<ListBean, ItemMainListBinding> {

    public ListAdapter(Context context) {
        super(DiffUtils.getDiffUtil().getListBeanItemCallback());

        setOnItemClickListener((item, position) ->
                Toast.makeText(context, item.getText(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getLayoutResId(int viewType) {
        return R.layout.item_main_list;
    }

    @Override
    public void onBind(ItemMainListBinding binding, ListBean item, RecyclerView.ViewHolder holder) {
        binding.setBean(item);
    }
}
