package com.example.android.test;

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

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FirstTest {


//    @Rule
//    public ActivityTestRule<MainActivity> mActivityRule
//            = new ActivityTestRule<MainActivity>(MainActivity.class);

    private UiDevice mDevice;

    @Before
    public void setUp() {
        // Initialize UiDevice instance

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // Start from the home screen
        mDevice.pressHome();

        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);
    }

    @Test
    public void startApp() throws UiObjectNotFoundException {

        mDevice.pressHome();

        UiObject2 allAppsButton = mDevice.findObject(By.res("com.google.android.apps.nexuslauncher:id/all_apps_handle"));

        allAppsButton.clickAndWait(Until.newWindow(), 3000);
        UiObject2 yuotubeIcon = mDevice.findObject(By.desc("YouTube"));

        yuotubeIcon.click();

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

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
