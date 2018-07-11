package com.example.android.test.steps;

import android.os.SystemClock;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import com.example.android.test.views.MainActivityView;

public class MainActivitySteps {


    private UiDevice mDevice;
    private MainActivityView view;

    public MainActivitySteps(UiDevice mDevice) {
        this.mDevice = mDevice;
        view = new MainActivityView(mDevice);
    }


    public MainActivitySteps openVideo() {
        UiObject2 video = view.findFirstVideo();
        video.clickAndWait(Until.newWindow(), 2000);
        return this;
    }

    public MainActivitySteps playFirstVideo() {
        UiObject2 video = view.findFirstVideo();
        video.click();
        SystemClock.sleep(30_000);
        mDevice.pressBack();
        return this;
    }

    public MainActivitySteps openTrending() {
        UiObject2 library = view.libraryFolder();
        library.clickAndWait(Until.newWindow(), 3000);
        return this;
    }
}
