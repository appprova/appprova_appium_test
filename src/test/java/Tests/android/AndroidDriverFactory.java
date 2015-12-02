/*
 * Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Tests.android;

import Tests.base.DriverFactory;
import Tests.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverFactory extends DriverFactory {

    protected DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities capabilities = super.getDesiredCapabilities();
        capabilities.setCapability("app-pkg", "com.appprova.appprovaandr");
        capabilities.setCapability("app-activity", ".activity.QuestionActivity_");
        return capabilities;
    }

    public String getDeviceName() {
        return "Android";
    }


    public String getAppName() {
        return "app.apk";
    }


    public String getPlatformName() {
        return "Android";
    }


    @Override
    protected AppiumDriver<MobileElement> createDriver() {
        try {
            return new AndroidDriver<MobileElement>(new URL(URL_STRING), getDesiredCapabilities());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}