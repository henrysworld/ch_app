package com.ch.ch_app.bean;

/**
 * Created by chenhe on 2015/10/23.
 */
public class NavigationEntity extends BaseEntity {

    private int iconResId;

    public NavigationEntity(String id, String name, int iconResId) {
        super(id, name);
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}
