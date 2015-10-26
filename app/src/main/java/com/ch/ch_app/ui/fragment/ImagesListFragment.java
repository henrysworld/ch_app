package com.ch.ch_app.ui.fragment;

import android.view.View;

import com.ch.ch_app.R;
import com.ch.ch_app.base.BaseFragment;
import com.ch.ch_library.eventbus.EventCenter;

/**
 * Created by chenhe on 2015/10/23.
 */
public class ImagesListFragment extends BaseFragment {
    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_images;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
