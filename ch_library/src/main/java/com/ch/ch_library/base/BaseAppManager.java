package com.ch.ch_library.base;

import android.app.Activity;
import android.content.Context;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/21.
 */
public class BaseAppManager {
    private static final String TAG = BaseAppManager.class.getSimpleName();

    private static BaseAppManager instances;
    private static List<Activity> mActivities = new LinkedList<Activity>();

    /**
     * get BaseAppManager instances with single instance
     * at:chenhe by:2015/10/21
     *
     * @return
     */
    public static BaseAppManager getInstances(){
        if(null == instances){
            synchronized (BaseAppManager.class){
                if (null == instances){
                    instances = new BaseAppManager();
                }
            }
        }
        return instances;
    }

    /**
     * add activity
     * by:chenhe at:2015/10/21
     *
     * @param activity
     */
    public synchronized void addActivity(Activity activity){
        mActivities.add(activity);
    }

    /**
     * get activitys size
     * by:chenhe at:2015/10/21
     *
     * @return
     */
    public int size(){
        return mActivities.size();
    }

    /**
     * get forword activity
     * by:chenhe at:2015/10/21
     *
     * @return
     */
    public synchronized Activity getForwordActivity(){
        return size() > 0 ? mActivities.get(size() - 1) : null;
    }

    /**
     * remove activity
     * by:chenhe at:2015/10/21
     *
     * @param activity
     */
    public synchronized void removeActivity(Activity activity){
        if (mActivities.contains(activity)){
            mActivities.remove(activity);
        }
    }

    /**
     * clear all activity
     * by:chenhe at:2015/10/21
     */
    public synchronized void clear(){
        for (int i = mActivities.size() - 1; i > -1; i--){
            Activity activity = mActivities.get(i);
            removeActivity(activity);
            activity.finish();
            i = mActivities.size();
        }
    }

    /**
     * clear all activity except top activity
     * by:chenhe at:2015/10/21
     */
    public synchronized void clearToTop(){
        for (int i = mActivities.size() - 2; i > -1; i--){
            Activity activity = mActivities.get(i);
            removeActivity(activity);
            activity.finish();
            i = mActivities.size() - 1;
        }
    }
}
