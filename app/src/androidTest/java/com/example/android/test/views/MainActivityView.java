package com.example.android.test.views;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;


public class MainActivityView {

    UiDevice mDevice;

    public MainActivityView(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    private static final String PACKAGE_NAME = "com.google.android.youtube:id/";


    public UiObject2 findFirstVideo() {
        return mDevice.wait(Until.findObject(By.res(PACKAGE_NAME + "thumbnail")), 5000);
    }

    public UiObject2 libraryFolder() {
        return mDevice.findObjects(By.res(PACKAGE_NAME + "image")).get(1);
    }

}
