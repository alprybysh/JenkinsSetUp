package com.example.android.test.views;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

public class SystemView {

    private static final String LAUNCHER_STRATEGY =  "com.google.android.apps.nexuslauncher:id/";

    private static final String APP_NAME = "YouTube";


    public UiObject2 findALlAppsButton (UiDevice mDevice){

        return mDevice.findObject(By.res(LAUNCHER_STRATEGY +"all_apps_handle"));
    }

    public  UiObject2 findAppIcon (UiDevice mDevice){
        return mDevice.findObject(By.desc(APP_NAME));
    }
}
