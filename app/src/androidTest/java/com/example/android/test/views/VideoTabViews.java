package com.example.android.test.views;

        import android.support.test.uiautomator.By;
        import android.support.test.uiautomator.UiDevice;
        import android.support.test.uiautomator.UiObject2;

public class VideoTabViews {
    private static final String PACKAGE_NAME = "com.google.android.youtube:id/";
    UiDevice mDevice;

    public VideoTabViews(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    public UiObject2 videoContainer() {
        return mDevice.findObject(By.res(PACKAGE_NAME + "watch_player_container"));
    }

    public UiObject2 channelContainer() {

        if (mDevice.findObject(By.res(PACKAGE_NAME + "channel_container")) == null){
            throw new RuntimeException("obj null");
        }

        return mDevice.findObject(By.res(PACKAGE_NAME + "channel_container"));
    }
}
