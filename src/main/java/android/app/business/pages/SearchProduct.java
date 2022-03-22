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
public class SearchProduct extends BaseTest {

    private AndroidDriver<AndroidElement> driver;

    public SearchProduct() {
        this.driver = BaseTest.androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search for Products, Brands and More']")
    private MobileElement SearchOption;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search for Products, Brands and More']")
    private MobileElement SearchHere;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='redmi note 11 pro']")
    private MobileElement redmiNote11Pro;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='REDMI Note 10S (Frost White, 64 GB)")
    private MobileElement selectRedmiNote10;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private MobileElement clickOnAddtoCart;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GO TO CART']")
//    private MobileElement GotoCart;

    @AndroidFindBy(id = "com.flipkart.android:id/cart_icon")
    private MobileElement GotoCart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Change']")
    private MobileElement ChangePinCode;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter pincode']")
    private MobileElement EnterPinCode;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Submit']")
    private MobileElement Submit;
}
