package com.ch.ch_app.presenter.impl;

import android.content.Context;

import com.ch.ch_app.interactor.CommonContainerInteractor;
import com.ch.ch_app.interactor.impl.ImagesContainerInteractorImpl;
import com.ch.ch_app.presenter.Presenter;
import com.ch.ch_app.view.CommonContainerView;

/**
 * Created by chenhe on 2015/10/23.
 */
public class ImagesContainerPresenterImpl implements Presenter {
    private Context mContext;
    private CommonContainerInteractor mCommonContainerInteractor;
    private CommonContainerView mCommonContainerView;

    public ImagesContainerPresenterImpl(Context context, CommonContainerView commonContainerView) {
        mContext = context;
        mCommonContainerView = commonContainerView;
        mCommonContainerInteractor = new ImagesContainerInteractorImpl();
    }
    @Override
    public void initialized() {
        mCommonContainerView.initializePagerViews(mCommonContainerInteractor.getCommonCategoryList(mContext));
    }
}
