package android.app.business.actions;

import android.app.business.pages.AppLaunchPage;
import android.app.business.pages.LoginPage;
import android.app.business.pages.SearchProduct;
import android.app.utils.core.AndroidScroll;
import android.app.utils.core.BaseTest;

import android.app.utils.core.WaitUtils;
import android.app.utils.testNG.MobileBaseTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.util.List;

import static android.app.utils.core.WaitUtils.*;

public class AndroidActions extends MobileBaseTest {

    public void loginIntoCinkoApp() throws InterruptedException, IOException {
        AppLaunchPage appLaunchPage = new AppLaunchPage();
        appLaunchPage.getSkipBtn().click();
        logPassTest("Skip Button Clicked Successfully");
        appLaunchPage.getLoginBtn().click();
        logPassTest("Login Button Clicked Successfully");
        waitUntilElementtobeClickable(appLaunchPage.getEmailBtn());
        appLaunchPage.getEmailBtn().sendKeys(getObject("Email"));
        logPassTest("Email Enter Successfully");
        appLaunchPage.getPasswordBtn().sendKeys(getObject("Password"));
        logPassTest("Password Enter Successfully");
        androidDriver.hideKeyboard();
        appLaunchPage.getSigninBtn().click();
        logPassTest("Sign In Successfully");
        waitUntilVisibilityOfElement(appLaunchPage.getBookingtext());
        waitUntilElementtobeClickable(appLaunchPage.getBookIn());
    }

    public void newTicket(){
        AppLaunchPage appLaunchPage = new AppLaunchPage();
        AndroidScroll androidScroll=new AndroidScroll();
        waitUntilElementtobeClickable(appLaunchPage.getMenuBtn());
        appLaunchPage.getMenuBtn().click();
        waitUntilElementtobeClickable(appLaunchPage.getMyTicket());
        appLaunchPage.getMyTicket().click();
        logPassTest("My Tickets Open Successfully");
        appLaunchPage.getAddTickets().click();
        logPassTest("Add Tickets Button Clicked Successfully");
        appLaunchPage.getHighPriority().click();
        logPassTest("Priority Set Successfully");
        appLaunchPage.getSelectCategory().click();
        logPassTest("Category Selected Successfully");
        waitUntilElementtobeClickable(appLaunchPage.getBehaviour());
        appLaunchPage.getBehaviour().click();
        androidDriver.hideKeyboard();
        waitUntilElementtobeClickable(appLaunchPage.getSubject());
        appLaunchPage.getSubject().setValue("improper behaviour");
        logPassTest("Subject Enter Successfully");
        appLaunchPage.getDescription().setValue("rude in behaviour");
        logPassTest("Description Set Successfully");
        appLaunchPage.getChooseFile().click();
        waitUntilElementtobeClickable(appLaunchPage.getTakePhoto());
        appLaunchPage.getTakePhoto().click();
        waitUntilElementtobeClickable(appLaunchPage.getBackCamera());
        appLaunchPage.getBackCamera().click();
        waitUntilElementtobeClickable(appLaunchPage.getClickPhoto());
        appLaunchPage.getClickPhoto().click();
        logPassTest("Photo Clicked Successfully");
        waitUntilElementtobeClickable(appLaunchPage.getFinalPhoto());
        appLaunchPage.getFinalPhoto().click();
        androidScroll.scrollToAnElementByText(androidDriver,"Submit");
        waitUntilElementtobeClickable(appLaunchPage.getSubmitBtn());
        appLaunchPage.getSubmitBtn().click();
        logPassTest("Tickets Submitted Successfully");

    }
    public void navigatetoTicketandAddComment() throws IOException, InterruptedException {
        AppLaunchPage appLaunchPage = new AppLaunchPage();
        AndroidScroll androidScroll=new AndroidScroll();
        loginIntoCinkoApp();
        logPassTest("Login Done successfully");
        logger.info("Login Done successfully");
        waitUntilElementtobeClickable(appLaunchPage.getMenuBtn());
        appLaunchPage.getMenuBtn().click();
        waitUntilElementtobeClickable(appLaunchPage.getMyTicket());
        appLaunchPage.getMyTicket().click();
        logPassTest("My Tickets Open Successfully");
        logger.info("My tickets Open successfully");
        for(int i=0;i<10;i++)
        {
            try {
                appLaunchPage.getTkt().isDisplayed();
                break;
            }catch(Exception e){
                androidScroll.swipeByElements(appLaunchPage.getStartElement(), appLaunchPage.getEndElement());
            }
        }
        logPassTest("Scroll till Element visible successfully");
        logger.info("Scroll till Element visible done successfully");
        appLaunchPage.getTkt().click();
        waitUntilElementtobeClickable(appLaunchPage.getAddComment());
        String Comment="Any Update on issuee";
        appLaunchPage.getAddComment().clear();
        //appLaunchPage.getAddComment().sendKeys(Comment);
        appLaunchPage.getAddComment().sendKeys(getObject("AddComments"));
        appLaunchPage.getAddCommentBtn().click();
        logPassTest("Comment Added successfully");
        logger.info("comment Added successfully");
        Thread.sleep(3000);
        androidDriver.navigate().back();
        androidScroll.pageReload();
        logPassTest("My Ticket Page Reloaded  successfully");
        logger.info("My ticket Page Reloaded successfully");
        for(int i=0;i<10;i++)
        {
            try {
                appLaunchPage.getTkt().isDisplayed();
                break;
            }catch(Exception e){
                androidScroll.swipeByElements(appLaunchPage.getStartElement(), appLaunchPage.getEndElement());
            }
        }
        appLaunchPage.getTkt().click();
        androidScroll.scrollToAnElementByText(androidDriver,getObject("AddComments"));
        logPassTest("Comment visible in Comment List");
        logger.info("comment visible in Comment List");

    }

    public void selectEnglishLanguageAndContinue() throws InterruptedException {

        AppLaunchPage appLaunchPage = new AppLaunchPage();
        AndroidScroll Bt= new AndroidScroll();
        appLaunchPage.getEnglish().click();
        logPassTest("Language Selected Successfully");
        logger.debug("opening webiste");
        appLaunchPage.getContinueBtn().click();
        logPassTest("Application launched Successfully");
        logger.info("Application Launched Successfully");
    }

    public  void LogIntoApp() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        waitUntilVisibilityOfElement(loginPage.getLogin());
        loginPage.getLogin().click();
        logPassTest("Clicked on Login button");
        logger.info("Clicked on Login button");
        //waitTillPageLoad();
        System.out.println("Dom of page *****************************************************************  "+androidDriver.getPageSource());
        fluientWaitforElement(loginPage.getContinue(),30,5);
        loginPage.getContinue().click();
        logPassTest("Entered Mobile Number");
        logger.info("Entered Mobile Number");
       // waitTillPageLoad();
        waitUntilVisibilityOfElement(loginPage.getVerify());
        loginPage.getVerify().click();
        logPassTest("Login Done Successfully");
        logger.info("Login Done Successfully");
    }

    public void SearchAProduct() throws InterruptedException {
        SearchProduct searchProduct= new SearchProduct();
        searchProduct.getSearchOption().click();
        logPassTest("Clicked On Search button");
        logger.info("Clicked On Search button");
        searchProduct.getSearchHere().setValue("redmi note 11 pro");
        logPassTest("Entered Redmi note 11 pro");
        logger.info("Entered Redmi note 11 pro");
        searchProduct.getRedmiNote11Pro().click();
        logPassTest("Change PinCode");
        logger.info("Change PinCode");
        searchProduct.getChangePinCode().click();
        searchProduct.getEnterPinCode().setValue("700048");
        searchProduct.getSubmit().click();
        logPassTest("PinCode Changed Successfully");
        logger.info("PinCode Changed Successfully");
        waitTillPageLoad();
        searchProduct.getSelectRedmiNote10().click();
        logPassTest("Product Selected Successfully");
        logger.info("Product Selected Successfully");
        searchProduct.getClickOnAddtoCart().click();
        logPassTest("Product added to cart Successfully");
        logger.info("Product added to cart Successfully");
        waitUntilElementtobeClickable(searchProduct.getGotoCart());
        searchProduct.getGotoCart().click();
        logPassTest("Product added to cart Successfully");
        logger.info("Product added to cart Successfully");

    }



}
