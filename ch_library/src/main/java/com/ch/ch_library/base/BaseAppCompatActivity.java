package com.ch.ch_library.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ch.ch_library.R;
import com.ch.ch_library.eventbus.EventCenter;
import com.ch.ch_library.loading.VaryViewHelperController;
import com.ch.ch_library.netstatus.NetChangeObserver;
import com.ch.ch_library.netstatus.NetStateReceiver;
import com.ch.ch_library.netstatus.NetUtils;
import com.ch.ch_library.utils.SmartBarUtils;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public abstract class BaseAppCompatActivity extends AppCompatActivity {

    protected static String TAG_LOG = null;
    protected Context mContext = null;

    /**
     * Screen information
     */
    protected int mScreenWidth = 0;
    protected int mScreenHeight = 0;
    protected float mScreenDensity = 0.0f;

    /**
     * network status
     */
    protected NetChangeObserver mNetChangeObserver = null;

    /**
     * loading view controller
     * by:chenhe at:2015/10/22
     */
    private VaryViewHelperController mVaryViewHelperController = null;

    /**
     * overridePendingTransition Mode
     * by:chenhe at:2015/10/21
     */
    public enum TransitionMode {
        LEFT, RIGHT, TOP, BOTTOM, SCALE, FADE
    }

    /**
     * toggle overridePendingTransition
     * by:chenhe at:2015/10/21
     *
     * @return
     */
    protected abstract boolean toggleOverridePendingTransition();

    /**
     * get the overridePendingTransition mode
     * by:chenhe at:2015/10/21
     *
     * @return
     */
    protected abstract TransitionMode getOverridePendingTransitionMode();

    /**
     * is appleStatusBarTranslucency
     * by:chenhe at:2015/10/21
     *
     * @return
     */
    protected abstract boolean isAppleStatusBarTranslucency();

    /**
     * bind layout resource file
     * by:chenhe at:2015/10/21
     *
     * @return
     */
    protected abstract int getContentViewLayoutID();

    /**
     * get bundle data
     * by:chenhe at:2015/10/21
     *
     * @param extras
     */
    protected abstract void getBundleExtras(Bundle extras);

    /**
     * is bind eventbus
     * by:chenhe at:2015/10/21
     *
     * @return
     */
    protected abstract boolean isBindEventBusHere();

    /**
     * network connected
     * by:chenhe at:2015/10/21
     */
    protected abstract void onNetworkConnected(NetUtils.NetType netType);

    /**
     * network disconnected
     * by:chenhe at:2015/10/21
     */
    protected abstract void onNetworkDisConnected();

    /**
     * init all views and all events
     * by:chenhe at:2015/10/21
     */
    protected abstract void initViewsAndEvents();

    /**
     * get loading target view
     * by:chenhe at:2015/10/21
     *
     * @return
     */
    protected abstract View getLoadingTargetView();

    /**
     * when event comming
     * by:chenhe at:2015/10/21
     *
     * @param eventCenter
     */
    protected abstract void onEventComming(EventCenter eventCenter);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(toggleOverridePendingTransition()){
            switch (getOverridePendingTransitionMode()){
                case LEFT:
                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                    break;
                case RIGHT:
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);
                    break;
                case TOP:
                    overridePendingTransition(R.anim.top_in, R.anim.top_out);
                    break;
                case BOTTOM:
                    overridePendingTransition(R.anim.bottom_in, R.anim.bottom_out);
                    break;
                case SCALE:
                    overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
                    break;
                case FADE:
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    break;

            }
        }
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if(null != extras){
            getBundleExtras(extras);
        }

        if(isBindEventBusHere()){
            EventBus.getDefault().register(this);
        }

        SmartBarUtils.hide(getWindow().getDecorView());
        setTranslucentStatus(isAppleStatusBarTranslucency());

        mContext = this;
        TAG_LOG = mContext.getClass().getSimpleName();
        BaseAppManager.getInstances().addActivity(this);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
        mScreenDensity = displayMetrics.density;

        if(getContentViewLayoutID() != 0){
            setContentView(getContentViewLayoutID());
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }

        mNetChangeObserver = new NetChangeObserver(){
            @Override
            public void onNetConnected(NetUtils.NetType netType) {
                super.onNetConnected(netType);
                onNetworkConnected(netType);
            }

            @Override
            public void onNetDisConnect() {
                super.onNetDisConnect();
                onNetworkDisConnected();
            }
        };

        NetStateReceiver.registerObserver(mNetChangeObserver);

        initViewsAndEvents();

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        if (null != getLoadingTargetView()){
            mVaryViewHelperController = new VaryViewHelperController(getLoadingTargetView());
        }
    }

    @Override
    public void finish() {
        super.finish();
        BaseAppManager.getInstances().removeActivity(this);
        if (toggleOverridePendingTransition()) {
            switch (getOverridePendingTransitionMode()) {
                case LEFT:
                    overridePendingTransition(R.anim.left_in,R.anim.left_out);
                    break;
                case RIGHT:
                    overridePendingTransition(R.anim.right_in,R.anim.right_out);
                    break;
                case TOP:
                    overridePendingTransition(R.anim.top_in,R.anim.top_out);
                    break;
                case BOTTOM:
                    overridePendingTransition(R.anim.bottom_in,R.anim.bottom_out);
                    break;
                case SCALE:
                    overridePendingTransition(R.anim.scale_in,R.anim.scale_out);
                    break;
                case FADE:
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
//        ButterKnife.reset(this);
        NetStateReceiver.removeRegisterObserver(mNetChangeObserver);
        if (isBindEventBusHere()) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * startActivity
     * by:chenhe at:2015/10/22
     *
     * @param clazz
     */
    public void readyGo(Class<?> clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     * by:chenhe at:2015/10/22
     *
     * @param clazz
     * @param bundle
     */
    public void readyGo(Class<?> clazz, Bundle bundle){
        Intent intent = new Intent(this, clazz);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     * by:chenhe at:2015/10/22
     *
     * @param clazz
     */
    public void readyGoThenKill(Class<?> clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     * by:chenhe at:2015/10/22
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     * by:chenhe at:2015/10/22
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode){
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     * by:chenhe at:2015/10/22
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * toggle show toast
     * by:chenhe at:2015/10/22
     *
     * @param msg
     */
    protected void showToast(String msg){
        if (!TextUtils.isEmpty(msg)){
            Snackbar.make(getLoadingTargetView(), msg, Snackbar.LENGTH_SHORT).show();
        }
    }

    /**
     * toggle show loading
     * by:chenhe at:2015/10/22
     *
     * @param toggle
     * @param msg
     */
    protected void toggleShowLoading(boolean toggle, String msg){
        if (null == mVaryViewHelperController){
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle){
            mVaryViewHelperController.showLoading(msg);
        } else {
            mVaryViewHelperController.restore();
        }
    }

    /**
     * toggle show empty
     * by:chenhe at:2015/10/22
     *
     * @param toggle
     */
    protected void toggleShowEmpty(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mVaryViewHelperController.showEmpty(msg, onClickListener);
        } else {
            mVaryViewHelperController.restore();
        }
    }

    /**
     * toggle show error
     * by:chenhe at:2015/10/22
     *
     * @param toggle
     */
    protected void toggleShowError(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mVaryViewHelperController.showError(msg, onClickListener);
        } else {
            mVaryViewHelperController.restore();
        }
    }


    /**
     * toggle show network error
     * by:chenhe at:2015/10/22
     *
     * @param toggle
     */
    protected void toggleNetworkError(boolean toggle, View.OnClickListener onClickListener) {
        if (null == mVaryViewHelperController) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }

        if (toggle) {
            mVaryViewHelperController.showNetworkError(onClickListener);
        } else {
            mVaryViewHelperController.restore();
        }
    }


    public void onEventMainThread(EventCenter eventCenter) {
        if (null != eventCenter) {
            onEventComming(eventCenter);
        }
    }

    /**
     * use SytemBarTintManager
     * by:chenhe at:2015/10/22
     *
     * @param tintDrawable
     */
    protected void setSystemBarTintDrawable(Drawable tintDrawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            if (tintDrawable != null) {
                mTintManager.setStatusBarTintEnabled(true);
                mTintManager.setTintDrawable(tintDrawable);
            } else {
                mTintManager.setStatusBarTintEnabled(false);
                mTintManager.setTintDrawable(null);
            }
        }

    }

    /**
     * set status bar translucent
     * by:chenhe at:2015/10/21
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on){
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }


}
