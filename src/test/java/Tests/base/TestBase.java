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

package Tests.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

/**
 * An abstract base for all of the Android tests within this package
 *
 * Responsible for setting up the Appium test Driver
 */
public abstract class TestBase {
    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
    protected static AppiumDriver<MobileElement> driver;
    protected DriverFactory driverFactory;

    protected TestBase(DriverFactory driverFactory){
        this.driverFactory = driverFactory;
    }

    @BeforeTest
    public abstract void setUpPage();

    @BeforeSuite
    public final void setUpAppium() throws MalformedURLException{
        driver = driverFactory.getDriver();
    }

    /**
     * Always remember to quit
     */
    @AfterSuite
    public void tearDownAppium(){
        driver.quit();
    }

    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
     */
    @AfterClass
    public void restartApp() {
        driver.resetApp();
    }
}