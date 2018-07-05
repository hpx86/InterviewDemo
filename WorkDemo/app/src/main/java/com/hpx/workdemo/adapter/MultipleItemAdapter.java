package com.hpx.workdemo.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpx.workdemo.GlideApp;
import com.hpx.workdemo.R;
import com.hpx.workdemo.beans.DataEntity;

import java.util.List;

public class MultipleItemAdapter extends
        BaseMultiItemQuickAdapter<DataEntity, BaseViewHolder> {

    private Context mContext;


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemAdapter(Context mContext,List<DataEntity> data) {
        super(data);
        this. mContext =  mContext ;
        addItemType(DataEntity.Companion.getTYPE_1(), R.layout.item_type_1);
        addItemType(DataEntity.Companion.getTYPE_2(), R.layout.item_type_2);
        addItemType(DataEntity.Companion.getTYPE_3(), R.layout.item_type_3);
    }


    @Override
    protected void convert(BaseViewHolder helper, DataEntity item) {
        //标签
        if (helper.getItemViewType() == item.Companion.getTYPE_1() ){
            helper.setText(R.id.tv_item_1_title,item.getTitle());

        //内容一
        }else if (helper.getItemViewType() == item.Companion.getTYPE_2()){

            helper.setText( R.id.tv_yieldvalue, item.getYieldvalue());
            helper.setText( R.id.tv_yieldtitle, item.getYieldtitle());
            helper.setText( R.id.tv_content, item.getContent());
            //helper.setText( R.id.tv_term, item.getTerm()+" "+item.getAmount());

            TextView tv_tags = helper.getView(R.id.tv_term) ;
            tv_tags.setText(item.getTerm()+" "+item.getAmount());

            GradientDrawable myGradient = (GradientDrawable) tv_tags.getBackground();
            myGradient.setSize(tv_tags.getWidth(),tv_tags.getHeight());
            //myGradient.setColor(getResources().getColor(R.color.c_dc0b));

        //内容2
        }else if (helper.getItemViewType() == item.Companion.getTYPE_3()){
            helper.setText( R.id.tv_type3_title, item.getTitle());
            helper.setText( R.id.tv_date, item.getDate());
            ImageView iv_pic = helper.getView(R.id.iv_pic) ;

            //Glide 4.0 使用
            GlideApp.with(mContext)
                    .load( item.getUrl() )
                    .centerCrop()
                    .placeholder(R.mipmap.menu)
                    .error(R.mipmap.menu)
                    .into( iv_pic ) ;

        }
    }
}
