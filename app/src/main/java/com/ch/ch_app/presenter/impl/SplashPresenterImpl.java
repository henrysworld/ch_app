package com.ch.ch_app.presenter.impl;

import android.content.Context;
import android.view.animation.Animation;

import com.ch.ch_app.interactor.SplashInteractor;
import com.ch.ch_app.interactor.impl.SplashInteractorImpl;
import com.ch.ch_app.presenter.Presenter;
import com.ch.ch_app.view.SplashView;

/**
 * Created by chenhe on 2015/10/22.
 */
public class SplashPresenterImpl implements Presenter{

    private SplashView mSplashView = null;
    private Context mContext = null;
    private SplashInteractor mSplashInteractor = null;

    public SplashPresenterImpl(Context context, SplashView splashView){
        if (splashView == null){
            throw new IllegalArgumentException("Constructor's parameters must not be Null");
        }
        mContext = context;
        mSplashView = splashView;
        mSplashInteractor = new SplashInteractorImpl();
    }

    @Override
    public void initialized() {
//        mSplashView.initializeUmengConfig();
        mSplashView.initializeViews(mSplashInteractor.getVersionName(mContext),
                mSplashInteractor.getCopyright(mContext),
                mSplashInteractor.getBackgroundImageResId());
        Animation animation = mSplashInteractor.getBackgroundImageAnimation(mContext);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mSplashView.navigateToHomePage();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashView.animateBackgroundImage(animation);
    }
}
