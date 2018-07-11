package com.example.android.test.tests;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.android.test.steps.ChannelTabSteps;
import com.example.android.test.steps.MainActivitySteps;
import com.example.android.test.steps.SystemStep;
import com.example.android.test.steps.VideoTabSteps;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTests {
    static UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    static SystemStep systemStep = new SystemStep(mDevice);
    static MainActivitySteps steps = new MainActivitySteps(mDevice);

    VideoTabSteps videoTabSteps = new VideoTabSteps(mDevice);
    ChannelTabSteps channelTabSteps = new ChannelTabSteps(mDevice);

    @BeforeClass
    public static void setUp() throws UiObjectNotFoundException {

        InstrumentationRegistry.getInstrumentation().getUiAutomation()
                .executeShellCommand("pm clear com.google.android.youtube");
        systemStep.startApp();
        systemStep.dismissInitialDialog();
    }

    @Test
    public void Test1openVideo() {
        steps.openVideo();
        Assert.assertTrue(videoTabSteps.isVideoOpen());
    }

    @Test
    public void Test2checkChannel() {
        videoTabSteps.openChannel();
        Assert.assertTrue(channelTabSteps.channelIsOPen());
    }

    @AfterClass
    public static void tearDown() {
        InstrumentationRegistry.getInstrumentation().getUiAutomation()
                .executeShellCommand("pm clear com.google.android.youtube");
    }

}
