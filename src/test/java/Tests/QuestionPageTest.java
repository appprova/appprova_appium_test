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

package Tests;

import Pages.QuestionPage;
import Tests.AbstractBaseTests.TestBase;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;


public class QuestionPageTest extends TestBase {

    private QuestionPage webViewPage;

    @BeforeTest
    @Override
    public void setUpPage() {
        webViewPage = new QuestionPage(driver);
    }

    @Test
    public void testSelectAlternatives() throws InterruptedException {
        List<MobileElement> alternatives = webViewPage.getAlternatives();
        assertFalse(alternatives.isEmpty());
        for (MobileElement element : alternatives){
            element.click();
            assertEquals(webViewPage.getSelectedAlternative(), element);
        }
    }

    @Test
    public void testSendAnswer(){
       webViewPage.getAnswerButton().click();
    }
}