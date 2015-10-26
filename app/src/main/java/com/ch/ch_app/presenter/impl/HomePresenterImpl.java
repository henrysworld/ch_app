package com.ch.ch_app.presenter.impl;

import android.content.Context;

import com.ch.ch_app.interactor.HomeInteractor;
import com.ch.ch_app.interactor.impl.HomeInteractorImpl;
import com.ch.ch_app.presenter.Presenter;
import com.ch.ch_app.view.HomeView;

/**
 * Created by chenhe on 2015/10/23.
 */
public class HomePresenterImpl implements Presenter {

    private Context mContext = null;
    private HomeView mHomeView = null;
    private HomeInteractor mHomeInteractor = null;
    public HomePresenterImpl(Context context, HomeView homeView){
        if (null == homeView) {
            throw new IllegalArgumentException("Constructor's parameters must not be Null");
        }

        mContext = context;
        mHomeView = homeView;
        mHomeInteractor = new HomeInteractorImpl();
    }

    @Override
    public void initialized() {
        mHomeView.initializeViews(mHomeInteractor.getPagerFragments(), mHomeInteractor.getNavigetionListData(mContext));
    }
}
