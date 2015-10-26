package com.ch.ch_app.interactor;

import android.content.Context;

import com.ch.ch_app.bean.NavigationEntity;
import com.ch.ch_library.base.BaseLazyFragment;

import java.util.List;

/**
 * Created by chenhe on 2015/10/23.
 */
public interface HomeInteractor {

    List<BaseLazyFragment> getPagerFragments();

    List<NavigationEntity> getNavigetionListData(Context context);
}
