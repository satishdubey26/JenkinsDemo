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
public class LoginPage extends BaseTest {

    private AndroidDriver<AndroidElement> driver;

    public LoginPage() {
        this.driver = BaseTest.androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "loginPageTitle")
    private MobileElement welcomeTitle;

    @AndroidFindBy(id = "loginPageFieldPhoneNumber")
    private MobileElement fieldPhoneNumber;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log in']")
    private MobileElement Login;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
    private MobileElement Continue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
    private MobileElement Verify;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index=1]")
    private MobileElement Logo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Trending Offers']")
    private MobileElement TradingOffer;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index=0]")
    private MobileElement AllCategories;


}
