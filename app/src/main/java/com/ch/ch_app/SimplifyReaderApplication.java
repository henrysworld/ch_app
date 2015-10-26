package com.ch.ch_app;

import android.app.Application;

import com.ch.ch_library.base.BaseAppManager;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by chenhe on 2015/10/22.
 */
public class SimplifyReaderApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobclickAgent.setDebugMode(true);
        MobclickAgent.updateOnlineConfig(this);
        MobclickAgent.openActivityDurationTrack(false);
//        UmengUpdateAgent.update(this);
//
//        VolleyHelper.getInstance().init(this);
//        ImageLoader.getInstance().init(ImageLoaderHelper.getInstance(this).getImageLoaderConfiguration(ApiConstants.Paths.IMAGE_LOADER_CACHE_PATH));
    }


    @Override
    public void onLowMemory() {
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onLowMemory();
    }

    public void exitApp() {
        BaseAppManager.getInstances().clear();
        System.gc();
        MobclickAgent.onKillProcess(this);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
