package com.hpx.workdemo.beans

import android.text.TextUtils
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 *
 * yieldvalue : 4.93%
 * yieldtitle : 预期年化收益率
 * content : 江苏"聚宝财富聚溢融"B6客户Y21(定制)APP
 * term : 187天
 * amount : 5万元起购
 * tags : 中低风险|收益稳定
*/
data class DataEntity(var yieldvalue: String?, var yieldtitle: String?,
                      var content:String?, var term:String?,
                      var amount:String?, var tags:String?,
                      var title:String?, var type:String?,
                      var date:String?, var url:String?):MultiItemEntity {
    /**
     * Android kotlin静态属性、静态方法
     * 只需要用 companion object 包裹相应代码块即可。
     * class Constants {
            companion object {
                 val BASE_URL = "http://192.168.x.x/decoration_axx_api/"
            }
        }
     * 调用
        Constants.Companion.getBASE_URL()
     */
    companion object {
         val TYPE_1 = 1
         val TYPE_2 = 2
         val TYPE_3 = 3
    }


    //实现多布局 需要的方法
    override fun getItemType(): Int {

        if (!TextUtils.isEmpty(type)){
            return TYPE_1
        }else if (!TextUtils.isEmpty(yieldvalue)){
            return TYPE_2
        }else{
            return TYPE_3
        }
    }
}