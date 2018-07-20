package com.example.android.test.tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.android.test.helpers.Retry;
import com.example.android.test.helpers.RetryRule;
import com.example.android.test.steps.TrendingSteps;
import com.example.android.test.steps.MainActivitySteps;
import com.example.android.test.steps.SystemStep;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static org.junit.Assert.assertThat;
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SmokeTests {

    static UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    static SystemStep systemStep = new SystemStep(mDevice);
    static MainActivitySteps steps = new MainActivitySteps(mDevice);
    TrendingSteps trendingSteps = new TrendingSteps(mDevice);


    @BeforeClass
    public static void setUp() throws UiObjectNotFoundException {
        InstrumentationRegistry.getInstrumentation().getUiAutomation()
                .executeShellCommand("pm clear com.google.android.youtube");
        systemStep.startApp();
        systemStep.dismissInitialDialog();

    }

    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Test
    @Retry
    public void test1PlayVideo() {
        steps.playFirstVideo();
    }

    @Test
    @Retry
    public void test2OpenTrending() {
        steps.openTrending();
        Assert.assertTrue(trendingSteps.isTrendingOpen());
    }

    @AfterClass
    public static void tearDown() throws IOException {
        InstrumentationRegistry.getInstrumentation().getUiAutomation()
                .executeShellCommand("pm clear com.google.android.youtube");
    }


}
