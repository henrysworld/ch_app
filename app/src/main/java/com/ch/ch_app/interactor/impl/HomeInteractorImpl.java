package com.ch.ch_app.interactor.impl;

import android.content.Context;

import com.ch.ch_app.R;
import com.ch.ch_app.bean.NavigationEntity;
import com.ch.ch_app.interactor.HomeInteractor;
import com.ch.ch_app.presenter.impl.HomePresenterImpl;
import com.ch.ch_app.ui.fragment.ImagesContainerFragment;
import com.ch.ch_app.ui.fragment.VideosContainerFragment;
import com.ch.ch_library.base.BaseLazyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhe on 2015/10/23.
 */
public class HomeInteractorImpl implements HomeInteractor {
    @Override
    public List<BaseLazyFragment> getPagerFragments() {
        List<BaseLazyFragment> fragments = new ArrayList<BaseLazyFragment>();
        fragments.add(new ImagesContainerFragment());
        fragments.add(new VideosContainerFragment());
        fragments.add(new VideosContainerFragment());
        return fragments;
    }

    @Override
    public List<NavigationEntity> getNavigetionListData(Context context) {
        List<NavigationEntity> navigationEntities = new ArrayList<>();
        String[] navigationArrays = context.getResources().getStringArray(R.array.navigation_list);
        navigationEntities.add(new NavigationEntity("", navigationArrays[0], R.drawable.ic_picture));
        navigationEntities.add(new NavigationEntity("", navigationArrays[1], R.drawable.ic_video));
        navigationEntities.add(new NavigationEntity("", navigationArrays[2], R.drawable.ic_music));
        return navigationEntities;
    }
}
