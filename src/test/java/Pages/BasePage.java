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

package Pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

/**
 * A base for all the pages within the suite
 */
abstract class BasePage {

    final AndroidDriver driver;
    private static final String WEBVIEW_CONTEXT = "WEBVIEW_com.appprova.appprovaandr";
    private static final String NATIVE_CONTEXT = "NATIVE_APP";


    BasePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    void switchToWebViewContext(){
        if (WEBVIEW_CONTEXT.equals(driver.getContext())){
            return;
        }
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return BasePage.this.driver.getContextHandles().contains(WEBVIEW_CONTEXT);
            }
        });
        driver.context(WEBVIEW_CONTEXT);
    }

    void switchToNativeContext(){
        if (NATIVE_CONTEXT.equals(driver.getContext())){
            return;
        }
        driver.context(NATIVE_CONTEXT);
    }
}