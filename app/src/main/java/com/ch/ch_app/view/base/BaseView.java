package com.ch.ch_app.view.base;

/**
 * Created by chenhe on 2015/10/22.
 */
public interface BaseView {
    /**
     * show loading message
     * by:chenhe at:2015/10/22
     *
     * @param msg
     */
    public void showLoading(String msg);

    /**
     * hide loading
     * by:chenhe at:2015/10/22
     */
    public void hideLoading();

    /**
     * show error
     * by:chenhe at:2015/10/22
     *
     * @param msg
     */
    public void showError(String msg);

    /**
     * show exception message
     * by:chenhe at:2015/10/22
     */
    void showException(String msg);

    /**
     * show net error
     * by:chenhe at:2015/10/22
     */
    void showNetError();
}
