
使用Demo中请求数据接口返回的数据，完成页面展示：

在上面的页面中，快捷菜单区域（新股申购）的菜单数据如下：
新股申购、股基大数据、盯盘助手、条件单、银河开户、银河优顾、资产全景、财富日历、大盘指数、沪深市场。

快捷区域每屏最多显示8个，超过8个时，向右滑动在下一屏显示。
每个菜单项的图标都使用“图片”文件夹中的“menu.png”即可。

银河优选和银河资讯的数据通过调用mainlib.jar中的com.galaxy.model.MainModel. MainModel中的queryData()方法获取。该方法返回一段json数据。具体格式见后文。

调用jar包中的下列方法获取要展示的数据，示例子：
import com.galaxy.model.MainModel;

…
MainModel model = new MainModel();
String data = model.queryData();
数据接口返回的数据样例如下，其中：
1.type字段代表该段数据的显示类型，开发时按照数据的顺序依据type类型进行展示。
2.返回数据类型的顺序是随机的，每种type下data字段中的数据条数也是随机的，该段数据样例仅作参考
3.银河优选类型的数据中的tags字段可能包含多个项目，格式用竖线分割XXX|XXX|XXX,，解析的时候需要注意。
[
{
    "title" : "银河优选",
    "type" : "hotsale",
    "data" : [
      {
        "term" : "187天",
        "yieldtitle" : "预期年化收益率",
        "content" : "江苏“聚宝财富聚溢融”B6客户Y21（定制）APP",
        "amount" : "5万元起购",
        "tags" : "低风险",
        "yieldvalue" : "4.93%"
      },
      {
        "term" : "636天",
        "yieldtitle" : "预期年化收益率",
        "content" : "“银河金山”收益凭证2467期",
        "amount" : "5万元起购",
        "tags" : "低风险｜首次购买",
        "yieldvalue" : "5.30%"
      },
      {
        "term" : "187天",
        "yieldtitle" : "预期年化收益率",
        "content" : "江苏“聚宝财富聚溢融”B6客户Y21（定制）APP",
        "amount" : "5万元起购",
        "tags" : "低风险",
        "yieldvalue" : "4.93%"
      },
      {
        "term" : "636天",
        "yieldtitle" : "预期年化收益率",
        "content" : "“银河金山”收益凭证2467期",
        "amount" : "5万元起购",
        "tags" : "低风险｜首次购买",
        "yieldvalue" : "5.30%"
      },
      {
        "term" : "187天",
        "yieldtitle" : "预期年化收益率",
        "content" : "江苏“聚宝财富聚溢融”B6客户Y21（定制）APP",
        "amount" : "5万元起购",
        "tags" : "低风险",
        "yieldvalue" : "4.93%"
      }
    ]
  },
  {
    "title" : "银河资讯",
    "type" : "news",
    "data" : [
      {
        "title" : "晚间重要公告集锦",
        "date" : "2018-01-05 20:58:08",
        "url" : "https:\/\/cdns.chinastock.com.cn\/cdn\/jlcms\/pic\/zxpt_v1_wjgg_s.jpg"
      },
      {
        "title" : "【银河军工行业2018投资策略】军民融合深度发展，迎价值重估投资良机，建议买入操作。",
        "date" : "2018-01-05 16:44:03",
        "url" : "https:\/\/cdns.chinastock.com.cn\/cdn\/jlcms\/pic\/JLCMS_DJ_HYYB.png"
      },
      {
        "title" : "我国首部上市药品目录集发布，第一批收录131个药品",
        "date" : "2018-01-05 14:41:13",
        "url" : "https:\/\/cdns.chinastock.com.cn\/cdn\/jlcms\/pic\/JLCMS_REMEN.png"
      }
    ]
  }
]

页面展示样例如下图：
1.其中顶部菜单的图片使用相同的图片即可，demo中提供。
2.菜单、优选和资讯标题、以及具体的优选和资讯项目都支持点击，弹出相应提示框即可。
3.涉及到颜色，使用相似的系统颜色即可，不需要与图上一致。
4.优选和资讯栏目的顺序要依据数据接口返回的来决定，做完的效果不一定与下图一致。
