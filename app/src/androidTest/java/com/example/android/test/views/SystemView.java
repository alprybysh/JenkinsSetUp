package com.example.android.test.views;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

public class SystemView {

    UiDevice mDevice;

    public SystemView(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    private static final String LAUNCHER_STRATEGY = "com.google.android.apps.nexuslauncher:id/";

    private static final String APP_NAME = "YouTube";


    public UiObject2 findALlAppsButton() {
        if (mDevice != null) {
            return mDevice.findObject(By.res(LAUNCHER_STRATEGY + "all_apps_handle"));
        } else {
            throw new RuntimeException("mDevice Null");
        }
    }

    public UiObject2 findAppIcon() {
        return mDevice.findObject(By.desc(APP_NAME));
    }

    public UiObject2 noThanksButton() {
        return mDevice.findObject(By.textContains("NO THANKS"));
    }
}
