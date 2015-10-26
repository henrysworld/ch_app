package com.ch.ch_app.view;

import android.view.animation.Animation;

/**
 * Created by chenhe on 2015/10/22.
 */
public interface SplashView {
    /**
     * set animate background
     *
     * @param animation
     */
    void animateBackgroundImage(Animation animation);

    /**
     * set view content
     *
     * @param versionName
     * @param copyright
     * @param backgroundResId
     */
    void initializeViews(String versionName, String copyright, int backgroundResId);

    /**
     * set umeng config
     */
    void initializeUmengConfig();

    /**
     * start where activity
     */
    void navigateToHomePage();
}
