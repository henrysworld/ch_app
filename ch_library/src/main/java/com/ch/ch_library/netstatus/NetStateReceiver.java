package com.ch.ch_library.netstatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ch.ch_library.utils.CLog;

import java.util.ArrayList;

/**
 * Created by chenhe on 2015/10/21.
 */
public class NetStateReceiver extends BroadcastReceiver {
    public final static String CUSTOM_ANDROID_NET_CHANGE_ACTION = "com.ch.ch_library.conn.CONNECTIVITY_CHANGE";
    private final static String ANDROID_NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    private final static String TAG = NetStateReceiver.class.getSimpleName();

    private static boolean isNetAvailable = false;
    private static NetUtils.NetType mNetType;
    private static ArrayList<NetChangeObserver> mNetChangeObservers = new ArrayList<NetChangeObserver>();
    private static BroadcastReceiver mBroadcastReceiver;

    /**
     * get NetStateReceiver instances
     * by:chenhe at:2015/10/21
     *
     * @return
     */
    private static BroadcastReceiver getReceiver(){
        if(null == mBroadcastReceiver){
            synchronized (NetStateReceiver.class){
                if (null == mBroadcastReceiver){
                    mBroadcastReceiver = new NetStateReceiver();
                }
            }
        }
        return mBroadcastReceiver;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        mBroadcastReceiver = NetStateReceiver.this;
        if(intent.getAction().equalsIgnoreCase(ANDROID_NET_CHANGE_ACTION) || intent.getAction().equalsIgnoreCase(CUSTOM_ANDROID_NET_CHANGE_ACTION)){
            if (!NetUtils.isNetworkAvailable(context)){
                CLog.i(TAG, "<--- network disconnected --->");
                isNetAvailable = false;
            } else {
                CLog.i(TAG, "<--- network connected --->");
                isNetAvailable = true;
                mNetType = NetUtils.getAPNType(context);
            }

        }
    }

    public static boolean isNetworkAvailable(){
        return isNetAvailable;
    }

    private void notifyObserver(){
        if(!mNetChangeObservers.isEmpty()){
            int size = mNetChangeObservers.size();
            for (int i = 0; i < size; i++){
                NetChangeObserver observer = mNetChangeObservers.get(i);
                if(observer != null){
                    if (isNetworkAvailable()){
                        observer.onNetConnected(mNetType);
                    } else {
                        observer.onNetDisConnect();
                    }
                }
            }
        }
    }

    /**
     * register observer
     * by:chenhe at:2015/10/21
     *
     * @param observer
     */
    public static void registerObserver(NetChangeObserver observer){
        if (mNetChangeObservers == null){
            mNetChangeObservers = new ArrayList<NetChangeObserver>();
        }
        mNetChangeObservers.add(observer);
    }

    public static void removeRegisterObserver(NetChangeObserver observer){
        if (mNetChangeObservers != null){
            if (mNetChangeObservers.contains(observer)){
                mNetChangeObservers.remove(observer);
            }
        }
    }
}
