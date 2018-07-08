package com.example.android.test.tests;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import com.example.android.test.steps.SystemStep;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SmokeTests {

    SystemStep systemStep = new SystemStep();

    @Before
    public void setUp() throws UiObjectNotFoundException {
        systemStep.startApp();
    }

    @Test
    public void playVideo() throws UiObjectNotFoundException {


      playVideo();
        // Next, in the apps tabs, we can simulate a user swiping until
        // they come to the Settings app icon. Since the container view
        // is scrollable, we can use a UiScrollable object.
//        UiScrollable appViews = new UiScrollable(
//                new UiSelector().scrollable(true));
//
//        // Set the swiping mode to horizontal (the default is vertical)
//        appViews.setAsHorizontalList();
//
//        // create a UiSelector to find the Settings app and simulate
//        // a user click to launch the app.
//        UiObject settingsApp = appViews
//                .getChildByText(new UiSelector()
//                                .className(android.widget.TextView.class.getName()),
//                        "Settings");
//        settingsApp.clickAndWaitForNewWindow();
//
//        // Validate that the package name is the expected one
//        UiObject settingsValidation = new UiObject(
//                new UiSelector()
//                        .packageName("com.android.settings"));
//        assertThat(settingsValidation.exists(), equalTo(true));
    }


}
