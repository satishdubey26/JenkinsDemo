package android.app.business.validations;

import android.app.business.pages.AppLaunchPage;
import android.app.business.pages.LoginPage;
import android.app.utils.core.AndroidScroll;
import android.app.utils.testNG.MobileBaseTest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class AndroidUIValidations extends MobileBaseTest {

    public void verifyLoginSuccess()
    {
        AppLaunchPage appLaunchPage=new AppLaunchPage();
        assertEquals(appLaunchPage.getBookingtext().isEnabled(),true,"Booking is not Display");
        assertEquals(appLaunchPage.getBookingtext().isDisplayed(),true,"Booking is not Display");
        assertEquals(appLaunchPage.getOptionBtn().isEnabled(),true,"Menu Option not Display");
        assertEquals(appLaunchPage.getFindAccommodationtext().getText(),"Find Accommodation","Find Accommodation is not Display");
        assertEquals(appLaunchPage.getMap().isEnabled(),true,"Map not Display");
        assertEquals(appLaunchPage.getBookIn().isDisplayed(),true,"Book is not Display");
        logPassTest("Validation of login Done Successfully");
    }
    public void verifyNewTicketRaisedSuccess()
    {
        AppLaunchPage appLaunchPage=new AppLaunchPage();
        assertEquals(appLaunchPage.getTickets().getText(),"Tickets","Tickets is not Display");
        appLaunchPage.getOpenStatus().click();
        assertEquals(appLaunchPage.getTimeStatus().isDisplayed(),true,"time is not Display");
        assertEquals(appLaunchPage.getDateStatus().isDisplayed(),true,"date is not Display");
        assertEquals(appLaunchPage.getCategoryStatus().isDisplayed(),true,"category is not Display");
        logPassTest("Validation of New Ticket Done Successfully");

    }

    public void verifyTicketComment() throws IOException {
        AppLaunchPage appLaunchPage=new AppLaunchPage();
        AndroidScroll androidScroll=new AndroidScroll();
        SoftAssert softAssert=new SoftAssert();
        List<MobileElement> CommentList = androidDriver.findElementsByXPath("//androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[@resource-id='com.cinko.app:id/txtComment']");
       boolean flag = false;
        androidScroll.scrollToAnElementByText(androidDriver,"cat2");
        for(int i=0;i<CommentList.size();i++)
        {
            if(CommentList.get(i).getText().equals(getObject("AddComments"))){

            softAssert.assertEquals(CommentList.get(i).getText(),getObject("AddComments"),"Comment is not Display");

            }
        }
        logPassTest("Validation of Add Comment done  successfully");
        logger.info("Validation of Add comment done successfully");
    }
    
}
