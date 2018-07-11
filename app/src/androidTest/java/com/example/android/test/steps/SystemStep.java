package com.example.android.test.steps;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import com.example.android.test.views.SystemView;

public class SystemStep {

   // private UiDevice mDevice;

    UiDevice mDevice;
    private SystemView systemView;

    public  SystemStep(UiDevice mDevice){
        this.mDevice = mDevice;
        systemView = new SystemView(mDevice);
    }


    public SystemStep startApp(){

        mDevice.pressHome();

        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);

        mDevice.pressHome();

        UiObject2 allAppsButton = systemView.findALlAppsButton();

        allAppsButton.clickAndWait(Until.newWindow(), 3000);

        UiObject2 yuotubeIcon = systemView.findAppIcon();

        yuotubeIcon.clickAndWait(Until.newWindow(), 3000);
        return this;
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

    public SystemStep  dismissInitialDialog (){
        UiObject2 noThanks = systemView.noThanksButton();
        if (noThanks != null){
            noThanks.clickAndWait(Until.newWindow(), 2000);
        }
        return this;
    }
     public boolean uiObjectExist (UiObject2 obj){
        return obj == null ? false : true;
    }
}
