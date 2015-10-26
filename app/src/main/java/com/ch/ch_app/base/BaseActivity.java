package com.ch.ch_app.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ch.ch_app.R;
import com.ch.ch_app.SimplifyReaderApplication;
import com.ch.ch_app.view.base.BaseView;
import com.ch.ch_library.base.BaseAppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by chenhe on 2015/10/22.
 */
public abstract class BaseActivity extends BaseAppCompatActivity implements BaseView {
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isApplyKitKatTranslucency()){
            setSystemBarTintDrawable(getResources().getDrawable(R.drawable.sr_primary));
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mToolbar = ButterKnife.findById(this, R.id.common_toolbar);
        if(null != mToolbar){
            setSupportActionBar(mToolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    protected SimplifyReaderApplication getBaseApplication() {
        return (SimplifyReaderApplication) getApplication();
    }


    @Override
    public void showError(String msg) {
        toggleShowError(true, msg, null);
    }
    @Override
    public void showLoading(String msg) {
        toggleShowLoading(true, null);
    }

    @Override
    public void hideLoading() {
        toggleShowLoading(false, null);
    }

    protected abstract boolean isApplyKitKatTranslucency();

}
