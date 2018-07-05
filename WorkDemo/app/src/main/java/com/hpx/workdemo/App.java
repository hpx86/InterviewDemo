package com.hpx.workdemo;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class App extends Application {
    private static Context mContext;
    private static App mApplication ;

    public static App getInstance(){ return mApplication ; }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this ;
        mApplication = this ;


    }

    public void showToast(String content){
        if (!TextUtils.isEmpty(content)){

            Toast.makeText(mContext,content,Toast.LENGTH_SHORT).show();
        }
    }
}
