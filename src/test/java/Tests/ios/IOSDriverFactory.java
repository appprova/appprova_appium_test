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

package Tests.ios;

import Tests.base.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverFactory extends DriverFactory {


    @Override
    protected String getDeviceName() {
        return "iPhone Simulator";
    }

    @Override
    protected String getAppName() {
        return "AppProva.app";
    }

    @Override
    protected String getPlatformName() {
        return "iOS";
    }

    @Override
    protected AppiumDriver<MobileElement> createDriver() {
        try {
            return new IOSDriver<MobileElement>(new URL(URL_STRING), getDesiredCapabilities());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}