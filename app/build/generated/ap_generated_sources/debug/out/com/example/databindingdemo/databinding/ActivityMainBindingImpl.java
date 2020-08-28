package com.example.databindingdemo.databinding;
import com.example.databindingdemo.R;
import com.example.databindingdemo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding implements com.example.databindingdemo.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rv.setTag(null);
        this.tv.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.databindingdemo.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.vm == variableId) {
            setVm((com.example.databindingdemo.model.ListBeanViewModel) variable);
        }
        else if (BR.adapter == variableId) {
            setAdapter((com.example.databindingdemo.adapter.ListAdapter) variable);
        }
        else if (BR.click == variableId) {
            setClick((com.example.databindingdemo.MainActivity.Click) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.example.databindingdemo.model.ListBeanViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    public void setAdapter(@Nullable com.example.databindingdemo.adapter.ListAdapter Adapter) {
        this.mAdapter = Adapter;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }
    public void setClick(@Nullable com.example.databindingdemo.MainActivity.Click Click) {
        this.mClick = Click;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.click);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmData((androidx.lifecycle.MutableLiveData<java.util.List<com.example.databindingdemo.bean.ListBean>>) object, fieldId);
            case 1 :
                return onChangeVmNotify((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmData(androidx.lifecycle.MutableLiveData<java.util.List<com.example.databindingdemo.bean.ListBean>> VmData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmNotify(androidx.lifecycle.MutableLiveData<java.lang.Boolean> VmNotify, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.Boolean vmNotifyGetValue = null;
        androidx.lifecycle.MutableLiveData<java.util.List<com.example.databindingdemo.bean.ListBean>> vmData = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> vmNotify = null;
        java.util.List<com.example.databindingdemo.bean.ListBean> vmDataGetValue = null;
        com.example.databindingdemo.model.ListBeanViewModel vm = mVm;
        com.example.databindingdemo.adapter.ListAdapter adapter = mAdapter;
        boolean androidxDatabindingViewDataBindingSafeUnboxVmNotifyGetValue = false;
        com.example.databindingdemo.MainActivity.Click click = mClick;

        if ((dirtyFlags & 0x2fL) != 0) {


            if ((dirtyFlags & 0x2dL) != 0) {

                    if (vm != null) {
                        // read vm.data
                        vmData = vm.data;
                    }
                    updateLiveDataRegistration(0, vmData);


                    if (vmData != null) {
                        // read vm.data.getValue()
                        vmDataGetValue = vmData.getValue();
                    }
            }
            if ((dirtyFlags & 0x26L) != 0) {

                    if (vm != null) {
                        // read vm.notify
                        vmNotify = vm.notify;
                    }
                    updateLiveDataRegistration(1, vmNotify);


                    if (vmNotify != null) {
                        // read vm.notify.getValue()
                        vmNotifyGetValue = vmNotify.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.notify.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxVmNotifyGetValue = androidx.databinding.ViewDataBinding.safeUnbox(vmNotifyGetValue);
            }
        }
        if ((dirtyFlags & 0x2dL) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x26L) != 0) {
            // api target 1

            com.example.databindingdemo.utils.RecyclerViewBindingAdapterUtil.notifyListChanged(this.rv, androidxDatabindingViewDataBindingSafeUnboxVmNotifyGetValue);
        }
        if ((dirtyFlags & 0x2dL) != 0) {
            // api target 1

            com.example.databindingdemo.utils.RecyclerViewBindingAdapterUtil.bindList(this.rv, adapter, vmDataGetValue);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            this.tv.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // click
        com.example.databindingdemo.MainActivity.Click click = mClick;
        // click != null
        boolean clickJavaLangObjectNull = false;



        clickJavaLangObjectNull = (click) != (null);
        if (clickJavaLangObjectNull) {


            click.toast();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.data
        flag 1 (0x2L): vm.notify
        flag 2 (0x3L): vm
        flag 3 (0x4L): adapter
        flag 4 (0x5L): click
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}