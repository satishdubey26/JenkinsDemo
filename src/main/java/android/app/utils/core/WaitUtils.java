package android.app.utils.core;

import android.app.business.pages.AppLaunchPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class WaitUtils extends BaseTest{
    // BaseTest.androidDriver.
    public static void waitforSeconds(int seconds)
    {
        BaseTest.androidDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void waitUntilVisibilityOfElement(MobileElement element)
    {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
//    public static void waitUntilLocated(AndroidDriver androidDriver, int waitingTime, By locator)
//    {
//        new WebDriverWait(driver, waitingTime).until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
    public static void waitUntilElementtobeClickable(MobileElement element)
    {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void fluientWaitforElement(MobileElement element, int TimoutSec, int pollingSec) {

        FluentWait fWait = new FluentWait(androidDriver);
        System.out.println("11111111111111111111111111111111111111111111111111111111111111111111");
        fWait.withTimeout(TimoutSec, TimeUnit.SECONDS);
        System.out.println("222222222222222222222222222222222222222222222222222222222222222222222222");
        fWait.pollingEvery(pollingSec, TimeUnit.SECONDS);
        System.out.println("3333333333333333333333333333333333333333333333333333333333333333333333333333");
        fWait.ignoring(NoSuchElementException.class, TimeoutException.class).ignoring(StaleElementReferenceException.class);
        System.out.println("444444444444444444444444444444444444444444444444444444444444444444444444444");
        for (int i = 0; i < 2; i++) {
            try {
                //fWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='reportmanager-wrapper']/div[1]/div[2]/ul/li/span[3]/i[@data-original--title='We are processing through trillions of data events, this insight may take more than 15 minutes to complete.']")));
                //fWait.until(ExpectedConditions.visibilityOf(element));
               fWait.until(ExpectedConditions.elementToBeClickable(element));

            } catch (Exception e) {

                System.out.println("Element Not found trying again - " + element.toString().substring(70));
                e.printStackTrace();

            }
        }





    }


    public enum DIRECTION
    {
        DOWN, UP, LEFT, RIGHT;
    }

    public static void swipe(AndroidDriver driver, DIRECTION direction, long duration) throws InterruptedException
    {
        Dimension size = driver.manage().window().getSize();

        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case RIGHT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.90);
                endX = (int) (size.width * 0.05);
                new TouchAction(driver)
                        .press(point(startX, startY))
                        .waitAction(waitOptions(ofMillis(duration)))
                        .moveTo(point(endX, startY))
                        .release()
                        .perform();
                break;

            case LEFT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.90);
                new TouchAction(driver)
                        .press(point(startX, startY))
                        .waitAction(waitOptions(ofMillis(duration)))
                        .moveTo(point(endX, startY))
                        .release()
                        .perform();

                break;
            }
        }
    public static void waitTillPageLoad() throws InterruptedException {
        Thread.sleep(10000);
    }


    }

