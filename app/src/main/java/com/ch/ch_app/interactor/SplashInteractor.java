package com.ch.ch_app.interactor;

import android.content.Context;
import android.view.animation.Animation;

/**
 * Created by chenhe on 2015/10/22.
 */
public interface SplashInteractor {
    /**
     * get background image id
     * by:chenhe at:2015/10/22
     *
     * @return
     */
    int getBackgroundImageResId();

    /**
     * get copyright
     * by:chenhe at:2015/10/22
     *
     * @param context
     * @return
     */
    String getCopyright(Context context);

    /**
     * get version name
     * by:chenhe at:2015/10/22
     *
     * @param context
     * @return
     */
    String getVersionName(Context context);

    /**
     * get background image animation
     * by:chenhe at:2015/10/22
     *
     * @param context
     * @return
     */
    Animation getBackgroundImageAnimation(Context context);

}
