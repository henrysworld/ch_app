package com.ch.ch_app.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ch.ch_library.base.BaseLazyFragment;

import java.util.List;

/**
 * Created by chenhe on 2015/10/23.
 */
public class VPFragmentAdapter extends FragmentPagerAdapter {

    private List<BaseLazyFragment> mListFragments = null;
    public VPFragmentAdapter(FragmentManager fm, List<BaseLazyFragment> mListFragments) {
        super(fm);
        this.mListFragments = mListFragments;
    }

    @Override
    public Fragment getItem(int position) {
        if (mListFragments != null && position > -1 && position < mListFragments.size()){
            return mListFragments.get(position);
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return null != mListFragments ? mListFragments.size() : 0;
    }

}
