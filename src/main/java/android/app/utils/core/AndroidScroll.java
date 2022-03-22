package android.app.utils.core;

import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class AndroidScroll extends BaseTest{

    public void scroll(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.longPress(point(fromX, fromY)).moveTo(point(toX, toY)).release().perform();

    }

    public void scrolltoElement(MobileElement element){
        ((JavascriptExecutor) androidDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void tapByElement (MobileElement androidElement) {
        new TouchAction(androidDriver)
                .tap(tapOptions().withElement(element(androidElement)))
                .waitAction(waitOptions(ofMillis(10000))).perform();
    }

    public void pressByElement (MobileElement element, long seconds) {
        new TouchAction(androidDriver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }
    public void pageReload(){
        int deviceWidth = androidDriver.manage().window().getSize().getWidth();
        int deviceHeight = androidDriver.manage().window().getSize().getHeight();
        int midX = (deviceWidth / 2);
        int midY = (deviceHeight / 2);
        int bottomEdge = (int) (deviceHeight * 0.85f);
        new TouchAction(androidDriver)
                .press(point(midX,midY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(midX, bottomEdge))
                .release().perform();

    }
    public void moveToElement(MobileElement element) throws InterruptedException
    {
        try
        {
            Thread.sleep(1000);
            Actions actions = new Actions (androidDriver);
            actions.moveToElement(element).build().perform();
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("moveToElement() error is >> " +e);
            //test.log(Status.FAIL, "Failed to move to element due to below issue.");
            //test.log(Status.FAIL, e.getMessage());

        }
    }
    public MobileElement scrollToAnElementByText(AppiumDriver<MobileElement> driver, String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }



    public void swipeByElements (MobileElement startElement, MobileElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
        new TouchAction(androidDriver)
                .press(point(startX,startY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endX, endY))
                .release().perform();
    }
    //===============================================================================================





}
