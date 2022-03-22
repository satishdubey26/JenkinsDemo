package android.app.business.pages;

import android.app.utils.core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AppLaunchPage extends BaseTest {

    private AndroidDriver<AndroidElement> driver;

    public AppLaunchPage() {
        this.driver = BaseTest.androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
    private MobileElement selectEnglishLanguage;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"English\"))")
    private  MobileElement English;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='हिन्दी']")
    private MobileElement selectHindiLanguage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Kannada']")
    private MobileElement selectKannadaLanguage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
    private MobileElement continueBtn;

//================================New Code APIDEMO=============

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App']")
    private MobileElement appBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Activity']")
    private MobileElement activityBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wallpaper']")
    private MobileElement wallpaperBtn;

    //====================================New Code Cinko==========================

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Skip']")
    private MobileElement skipBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    private MobileElement loginBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email Address']")
    private MobileElement emailBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    private MobileElement passwordBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign In']")
    private MobileElement signinBtn;

    //==========================for verify login Page Cinko========================

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']")
    private MobileElement Bookingtext;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='2']")
    private MobileElement optionBtn;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.cinko.app:id/navigationIcon']")
    private MobileElement menuBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Find Accommodation']")
    private MobileElement FindAccommodationtext;

    @AndroidFindBy(className = "android.view.View")
    private MobileElement map;

    @AndroidFindBy(xpath="//android.widget.Button[@text='Book']")
    private MobileElement bookIn;

    //=============================New Ticket=========================================

    @AndroidFindBy(xpath="//android.widget.TextView[@text='My Ticket']")
    private MobileElement myTicket;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Add Tickets']")
    private MobileElement addTickets;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
    private MobileElement highPriority;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Select Category']")
    private MobileElement selectCategory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
    private MobileElement behaviour;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.cinko.app:id/txt_subject']")
    private MobileElement subject;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.cinko.app:id/txt_description']")
    private MobileElement description;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.cinko.app:id/txt_attach']")
    private MobileElement chooseFile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1']")
    private MobileElement takePhoto;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.asus.camera:id/button_capture']")
    private MobileElement clickPhoto;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.asus.camera:id/button_used']")
    private MobileElement finalPhoto;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.asus.camera:id/button_switch_camera']")
    private MobileElement backCamera;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.cinko.app:id/txtSubmit']")
    private MobileElement submitBtn;

    //============================Verify New Tickets=====================================

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.cinko.app:id/tv_title']")
    private MobileElement tickets;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.cinko.app:id/txtstatus']")
    private MobileElement openStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.cinko.app:id/txtTime']")
    private MobileElement timeStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.cinko.app:id/txtDate']")
    private MobileElement dateStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.cinko.app:id/txtCategory']")
    private MobileElement categoryStatus;

    //=========================Navigate to Ticket and Add Comment=================================

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Open'])[3]")
    private MobileElement startElement;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Open'])[1]")
    private MobileElement endElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='cat2']")
    private MobileElement tkt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.cinko.app:id/txtAddComments']")
    private MobileElement addCommentBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Comments']")
    private MobileElement addComment;






}
