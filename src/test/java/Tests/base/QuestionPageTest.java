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

import Pages.base.QuestionPage;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;


public abstract class QuestionPageTest extends TestBase {

    protected QuestionPage questionPage;

    protected QuestionPageTest(DriverFactory driverFactory) {
        super(driverFactory);
    }

    @BeforeTest
    @Override
    public void setUpPage() {
        questionPage = new QuestionPage(driverFactory.getDriver());
    }

    @Test
    public void testSelectAlternatives() throws InterruptedException {
        List<MobileElement> alternatives = questionPage.getAlternatives();
        assertFalse(alternatives.isEmpty());
        for (MobileElement element : alternatives){
            element.click();
            assertEquals(questionPage.getSelectedAlternative().getText(), element.getText());
        }
    }

    @Test
    public void testSendAnswer(){
       questionPage.getAnswerButton().click();
    }
}