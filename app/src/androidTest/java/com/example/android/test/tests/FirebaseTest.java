package com.example.android.test.tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import com.example.android.test.MainActivity;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class FirebaseTest {

    static  UiDevice mDevice;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @BeforeClass
    public static void setUp() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        Assert.assertNotNull(mDevice);
    }

    @Test
    public void checkCreateButton() {
        UiObject2 ui = mDevice.wait(Until.findObject(By.res("com.example.android.test:id/fab")), 2000);
        Assert.assertNotNull(ui);
    }

    @AfterClass
    public static void tearDown() {
     mDevice.pressHome();
    }

}
