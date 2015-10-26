package com.ch.ch_app.base;

import android.view.View;

import com.ch.ch_app.view.base.BaseView;
import com.ch.ch_library.base.BaseLazyFragment;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by Administrator on 2015/10/23.
 */
public abstract class BaseFragment extends BaseLazyFragment implements BaseView {
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void showError(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showException(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showNetError() {
        toggleNetworkError(true, null);
    }

    @Override
    public void showLoading(String msg) {
        toggleShowLoading(true, null);
    }

    @Override
    public void hideLoading() {
        toggleShowLoading(false, null);
    }
}
