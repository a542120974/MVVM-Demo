package com.example.databindingdemo.utils;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

public class RecyclerViewBindingAdapterUtil {

    @BindingAdapter(value = {"adapter", "submitList"}, requireAll = false)
    public static void bindList(RecyclerView recyclerView, ListAdapter adapter, List list) {
        if (recyclerView != null && list != null) {
            if (recyclerView.getAdapter() == null) {
                if (recyclerView.getLayoutManager() != null) {
                    if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                        int spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
                        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), spanCount));
                    } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    } else if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                        int spanCount = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
                        int orientation = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getOrientation();
                        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(spanCount, orientation));
                    }
                }

                recyclerView.setAdapter(adapter);
            }

            adapter.submitList(list);
        }
    }

    @BindingAdapter(value = {"notifyDataSetChanged"})
    public static void notifyListChanged(RecyclerView recyclerView, boolean notify) {
        if (notify && recyclerView != null && recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
