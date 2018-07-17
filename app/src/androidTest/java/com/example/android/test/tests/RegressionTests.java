package com.example.android.test.tests;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.android.test.steps.ChannelTabSteps;
import com.example.android.test.steps.MainActivitySteps;
import com.example.android.test.helpers.Retry;
import com.example.android.test.helpers.RetryRule;
import com.example.android.test.steps.SystemStep;
import com.example.android.test.steps.VideoTabSteps;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

@RunWith(AndroidJUnit4.class)
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
    //Set retry count argument
    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Test
    @Retry
    public void test1OpenVideo() {
        steps.openVideo();
        Assert.assertTrue(videoTabSteps.isVideoOpen());
    }

    @Test
    @Retry
    public void test2CheckChannel() {
        steps.openVideo();
        videoTabSteps.openChannel();
        Assert.assertTrue(channelTabSteps.channelIsOPen());
    }

    @AfterClass
    public static void tearDown() {
        InstrumentationRegistry.getInstrumentation().getUiAutomation()
                .executeShellCommand("pm clear com.google.android.youtube");
    }

}
