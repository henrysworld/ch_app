package com.ch.ch_app.ui.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.ch.ch_app.R;
import com.ch.ch_app.base.BaseFragment;
import com.ch.ch_app.bean.BaseEntity;
import com.ch.ch_app.presenter.Presenter;
import com.ch.ch_app.presenter.impl.ImagesContainerPresenterImpl;
import com.ch.ch_app.ui.adapter.ImagesContainerPagerAdapter;
import com.ch.ch_app.view.CommonContainerView;
import com.ch.ch_library.eventbus.EventCenter;
import com.ch.ch_library.smartlayout.SmartTabLayout;
import com.ch.ch_library.widgets.XViewPager;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2015/10/23.
 */
public class ImagesContainerFragment extends BaseFragment implements CommonContainerView{

    @Bind(R.id.fragment_images_pager)
    XViewPager mViewPager;

    @Bind(R.id.fragment_images_tab_smart)
    SmartTabLayout mSmartTabLayout;

    private Presenter mImagesContainerPresenter = null;

    @Override
    protected void onFirstUserVisible() {
        mImagesContainerPresenter = new ImagesContainerPresenterImpl(mContext, this);
        mImagesContainerPresenter.initialized();
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

    @Override
    public void initializePagerViews(List<BaseEntity> categoryList) {
        if (null != categoryList && !categoryList.isEmpty()){
            mViewPager.setOffscreenPageLimit(categoryList.size());
            mViewPager.setAdapter(new ImagesContainerPagerAdapter(getSupportFragmentManager(), categoryList));
            mSmartTabLayout.setViewPager(mViewPager);
            mSmartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    ImagesListFragment fragment = (ImagesListFragment) mViewPager.getAdapter().instantiateItem(mViewPager, position);
//                    fragment.onPageSelected(position, categoryList.get(position).getId());
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }
}
