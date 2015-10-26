package com.ch.ch_app.interactor;

import android.content.Context;

import com.ch.ch_app.bean.BaseEntity;

import java.util.List;

/**
 * Created by chenhe on 2015/10/23.
 */
public interface CommonContainerInteractor {
    List<BaseEntity> getCommonCategoryList(Context context);
}
