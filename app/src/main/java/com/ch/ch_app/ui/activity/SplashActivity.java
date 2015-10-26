package com.ch.ch_app.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.ch.ch_app.MainActivity;
import com.ch.ch_app.R;
import com.ch.ch_app.base.BaseActivity;
import com.ch.ch_app.presenter.Presenter;
import com.ch.ch_app.presenter.impl.SplashPresenterImpl;
import com.ch.ch_app.view.SplashView;
import com.ch.ch_library.base.BaseAppCompatActivity;
import com.ch.ch_library.eventbus.EventCenter;
import com.ch.ch_library.netstatus.NetUtils;
import com.umeng.analytics.AnalyticsConfig;

import butterknife.Bind;

public class SplashActivity extends BaseActivity implements SplashView{

    @Bind(R.id.splash_image)
    ImageView mSplashImage;

    @Bind(R.id.splash_version_name)
    TextView mVersionName;

    @Bind(R.id.splash_copyright)
    TextView mCopyright;

    private Presenter mSplashPresenter = null;


    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override
    protected boolean isAppleStatusBarTranslucency() {
        return true;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType netType) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected void initViewsAndEvents() {
        mSplashPresenter = new SplashPresenterImpl(this, this);
        mSplashPresenter.initialized();
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return false;
    }

    @Override
    public void animateBackgroundImage(Animation animation) {
        mSplashImage.startAnimation(animation);
    }

    @Override
    public void initializeViews(String versionName, String copyright, int backgroundResId) {
        mCopyright.setText(copyright);
        mVersionName.setText(versionName);
        mSplashImage.setImageResource(backgroundResId);
    }

    @Override
    public void initializeUmengConfig() {
//        AnalyticsConfig.setAppkey(SplashActivity.this, "55018d77fd98c5901e000a09");
//        AnalyticsConfig.setChannel("SimplifyReader");
    }

    @Override
    public void navigateToHomePage() {
        readyGoThenKill(HomeActivity.class);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void showException(String msg) {

    }

    @Override
    public void showNetError() {

    }
}
