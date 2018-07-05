package com.hpx.workdemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpx.workdemo.R;

import java.util.List;

public class HorizontalAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HorizontalAdapter(int layoutResId,  List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_title,item );
    }
}
