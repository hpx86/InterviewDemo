package com.hpx.workdemo;

import com.galaxy.model.MainModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hpx.workdemo.beans.DataModel;

import java.lang.reflect.Type;
import java.util.List;

public class Heee {
    public List<DataModel> sh(){
        MainModel model = new MainModel();
        String data = model.queryData();
        Type type=new TypeToken<List<DataModel>>(){}.getType();

        List<DataModel> listData = new Gson().fromJson(data,type);
        /*//使用Logger
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.e(""+ listData.toString() );*/
        return listData;
    }
}
