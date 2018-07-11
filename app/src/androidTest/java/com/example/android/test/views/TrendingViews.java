package com.example.android.test.views;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;


public class TrendingViews {

    UiDevice mDevice;

    public TrendingViews(UiDevice mDevice) {
        this.mDevice = mDevice;
    }


    public UiObject2 title() {
        return mDevice.findObject(By.text("Trending"));

    }
}
