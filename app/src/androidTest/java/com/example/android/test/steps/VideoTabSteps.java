package com.example.android.test.steps;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;


import com.example.android.test.views.VideoTabViews;

public class VideoTabSteps {

    private VideoTabViews view;
    SystemStep systemStep;

    public VideoTabSteps (UiDevice mDevice){

        view  = new VideoTabViews(mDevice);
        systemStep = new SystemStep(mDevice);

    }

    public boolean isVideoOpen(){
        return systemStep.uiObjectExist(view.videoContainer());
    }

    public VideoTabSteps openChannel(){
        view.channelContainer().clickAndWait(Until.newWindow(), 2000);
        return this;
    }
}
