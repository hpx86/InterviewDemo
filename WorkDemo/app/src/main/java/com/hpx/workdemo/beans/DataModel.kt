package com.hpx.workdemo.beans

/**
 * title : 银河优选
 * data : [{"yieldvalue":"4.93%","yieldtitle":"预期年化收益率","content":"江苏\"聚宝财富聚溢融\"B6客户Y21(定制)APP","term":"187天","amount":"5万元起购","tags":"中低风险|收益稳定"},{"yieldvalue":"4.18%~6.00%","yieldtitle":"七日年化收益率","content":"\"银河金山\"收益凭证2465期(首次购买专享)","term":"35天","amount":"1万元起购","tags":"低风险"}]
 * type : hotsale
 */
data class DataModel(var title:String,var type:String,var data:List<DataEntity>)