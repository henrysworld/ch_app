package com.ch.ch_library.loading;

import android.content.Context;
import android.view.View;

/**
 * Created by chenhe on 2015/10/22.
 */
public interface IVaryViewHelper {
    public View getCurrentLayout();
    public void restoreView();
    public void showLayout(View view);
    public View inflate(int layoutId);
    public Context getContext();
    public View getView();
}
