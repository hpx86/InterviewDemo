package com.hpx.workdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.hpx.workdemo.adapter.HorizontalAdapter
import com.hpx.workdemo.adapter.MultipleItemAdapter
import com.hpx.workdemo.beans.DataEntity


/**
 * 整体布局为：NestedScrollView + RecyclerView
 */

class MainActivity : AppCompatActivity() {

    //主RecyclerView
    private lateinit var mRecyclerView:RecyclerView
    //mRecyclerView 多类型Item适配器
    private lateinit var mAdapter:MultipleItemAdapter
    // 数据源（数据实体 集合）
    private lateinit var mData:MutableList<DataEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById(R.id.recyclerView_horizontal)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        //为mRecyclerView的Item之间添加 一条 1dp的灰色分割线
        mRecyclerView.addItemDecoration(SimpleDividerDecoration(this))

        mData = ArrayList<DataEntity>()
        mAdapter = MultipleItemAdapter(this,mData)
        //设置 空布局
        //mAdapter.setEmptyView()

        mRecyclerView.adapter = mAdapter

        //代码中创建并为RecyclerView添加 头View
        addHeaderView()

        //添加Item点击事件
        mAdapter.setOnItemClickListener { adapter, view, position ->
            App.getInstance().showToast("内容 点击："+position)
        }

    }

    fun addHeaderView(){
        var reclerView = RecyclerView(this)

        var params= RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.MATCH_PARENT)
        reclerView.layoutParams = params

        var titles = ArrayList<String>()
        var s = resources.getStringArray(R.array.titles)
        var max = s.size-1
        loop@ for (i in 0..max){
            titles.add(s[i])
        }

        var titleAdapter = HorizontalAdapter(R.layout.item,titles)

        reclerView.layoutManager = GridLayoutManager(this,
                2,
                GridLayoutManager.HORIZONTAL,
                false)
        reclerView.adapter = titleAdapter

        titleAdapter.setOnItemClickListener { adapter, view, position ->
            App.getInstance().showToast("头部 点击："+position)
        }


        mAdapter.setHeaderView(reclerView)
    }

    /**
     * 在页面打开后监测 数据集合中是否又数据
     * 没有数据 就获取数据并解析
     */
    override fun onResume() {
        super.onResume()

        if (mData.isEmpty()){

            /**随便写的一个Java类用于解决Gson解析集合型Json过程中的泛型擦出
             * Kotlin代码暂时无法实现？？？
             */
            var e = Heee()
            var listData = e.sh()

            if (!listData.isEmpty())
            for (d in listData){
                mData.add(DataEntity(null,null,null,null,null,
                        null,d.title, d.type,null,null))
                if (!d.data.isEmpty())
                    mData.addAll( d.data )
            }
            mAdapter.notifyDataSetChanged()

        }
    }
}
