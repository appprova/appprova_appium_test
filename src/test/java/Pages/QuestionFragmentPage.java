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

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class QuestionFragmentPage extends BasePage{


    public MobileElement answerButton;

    public QuestionFragmentPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        switchToWebViewContext();
    }

    @SuppressWarnings("unchecked")
    public List<MobileElement> getAlternatives(){
        return (List<MobileElement>)driver.findElementsByCssSelector("li");
    }

    public MobileElement getSelectedAlternative(){
        return (MobileElement) driver.findElementByCssSelector(".active");
    }

}
