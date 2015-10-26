package com.ch.ch_app.view;

import com.ch.ch_app.bean.NavigationEntity;
import com.ch.ch_library.base.BaseLazyFragment;

import java.util.List;

/**
 * Created by Administrator on 2015/10/23.
 */
public interface HomeView {
    void initializeViews(List<BaseLazyFragment> fragments, List<NavigationEntity> navigationList);
}
