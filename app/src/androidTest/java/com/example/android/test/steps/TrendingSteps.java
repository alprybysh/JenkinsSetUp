package com.example.android.test.steps;

import android.support.test.uiautomator.UiDevice;

import com.example.android.test.views.TrendingViews;

public class TrendingSteps {


    private TrendingViews view;
    SystemStep systemStep;

    public TrendingSteps(UiDevice mDevice){

        view  = new TrendingViews(mDevice);
        systemStep = new SystemStep(mDevice);

    }

    public boolean isTrendingOpen(){
        return systemStep.uiObjectExist(view.title());
    }
}
