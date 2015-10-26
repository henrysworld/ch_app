package com.ch.ch_app.view;

import com.ch.ch_app.bean.BaseEntity;

import java.util.List;

/**
 * Created by chenhe on 2015/10/23.
 */
public interface CommonContainerView {
    void initializePagerViews(List<BaseEntity> categoryList);
}
