package com.test.integration.mobile;

import android.app.business.actions.AndroidActions;
import android.app.business.validations.AndroidUIValidations;

import android.app.utils.testNG.Customlistner;
import android.app.utils.testNG.MobileBaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import  org.apache.logging.log4j.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



@Listeners(Customlistner.class)

public class LoginLogoutTest extends MobileBaseTest{

    private static final Logger logger = LogManager.getLogger(LoginLogoutTest.class);

    AndroidActions androidActions = new AndroidActions();
    AndroidUIValidations uiValidations = new AndroidUIValidations();

    @Test(priority = 1)
    public void loginIntoCinkoApp() throws InterruptedException, IOException {
        androidActions.navigatetoTicketandAddComment();

        uiValidations.verifyTicketComment();

    }

   // @Test(priority = 2)
    public void NewTicket(){
        androidActions.newTicket();
        uiValidations.verifyNewTicketRaisedSuccess();
    }

    //@Test(priority=1)
    public void launchAppAndSelectLanguage() throws InterruptedException {
        androidActions.selectEnglishLanguageAndContinue();
    }

   // @Test(priority=2)
    public void Login() throws InterruptedException {
        androidActions.LogIntoApp();
        uiValidations.verifyLoginSuccess();


    }

    //@Test(priority=3)
    public void SearchProduct() throws InterruptedException {
        androidActions.SearchAProduct();
    }

    @AfterClass
    public void EndReport() {
        CloseReport();

    }

}

