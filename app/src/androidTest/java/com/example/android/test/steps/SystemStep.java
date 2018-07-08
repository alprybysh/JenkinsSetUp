package com.example.android.test.steps;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import com.example.android.test.views.SystemView;

public class SystemStep {

    private UiDevice mDevice;

    private SystemView systemView = new SystemView();

    public void startApp(){

        // Initialize UiDevice instance

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // Start from the home screen
        mDevice.pressHome();

        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);

        mDevice.pressHome();

        UiObject2 allAppsButton = systemView.findALlAppsButton(mDevice);

        allAppsButton.clickAndWait(Until.newWindow(), 3000);

        UiObject2 yuotubeIcon = systemView.findAppIcon(mDevice);

        yuotubeIcon.click();
    }

    private static String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
