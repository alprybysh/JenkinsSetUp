package com.example.android.test.views;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

public class ChannelTabViews {

    private static final String PACKAGE_NAME = "com.google.android.youtube:id/";
    UiDevice mDevice;

    public ChannelTabViews(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    public UiObject2 videoContainer() {
        return mDevice.findObject(By.res(PACKAGE_NAME + "channel_banner_container"));
    }

}

