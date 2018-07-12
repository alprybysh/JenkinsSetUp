package com.example.android.test.steps;

import android.support.test.uiautomator.UiDevice;

import com.example.android.test.views.ChannelTabViews;
import com.example.android.test.views.MainActivityView;

import java.io.IOException;

public class ChannelTabSteps {

    private UiDevice mDevice;
    private ChannelTabViews view;
    SystemStep systemStep;

    public ChannelTabSteps(UiDevice mDevice) {
        this.mDevice = mDevice;
        view = new ChannelTabViews(mDevice);
        systemStep = new SystemStep(mDevice);
    }

    public boolean channelIsOPen() {
        return systemStep.uiObjectExist(view.videoContainer());
    }
}
