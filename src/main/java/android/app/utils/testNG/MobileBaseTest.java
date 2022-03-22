package android.app.utils.testNG;

import android.app.business.AppiumServiceHelper;
import android.app.utils.core.BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.model.Device;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import sun.rmi.runtime.Log;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MobileBaseTest extends BaseTest {


    private int aapiumPort = 4788;
   // public static ExtentTest extentTest;



    @BeforeSuite
    public void serviceSetup() throws Exception {

        AppiumServiceHelper.startDefaultService(aapiumPort);
        logger.info("Appium Server Start Successfully");

        DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ANDROID);
        DesiredCapabilities capabilites = new DesiredCapabilities();

        //capabilites.setCapability(MobileCapabilityType.APP, "C:\\Users\\rj\\IdeaProjects\\AndroidNativeApp\\src\\main\\java\\android\\app\\apkFile\\FlipkartApp.apk");
       // capabilites.setCapability(MobileCapabilityType.APP, "C:\\Users\\rj\\IdeaProjects\\AndroidNativeApp\\src\\main\\java\\android\\app\\apkFile\\ApiDemos-debug.apk");

        if (deviceInfo.anyDeviceConnected()) {
            Device device = deviceInfo.getFirstDevice();
            capabilites.setCapability("deviceName", device.getModelNumber());
            capabilites.setCapability("udid", device.getUniqueDeviceID());
            capabilites.setCapability("platformVersion", device.getProductVersion());
            capabilites.setCapability("platformName", device.getDeviceProductName());
            logger.info("Device Connected Successfully");
            capabilites.setCapability("appPackage", "com.cinko.app");
            capabilites.setCapability("appActivity", "com.cinko.app.activity.SplashActivity");
            logger.info("Application Installed Successfully");
            capabilites.setCapability("autoGrantPermissions", true);

            BaseTest.androidDriver = new AndroidDriver(new URL("http://127.0.0.1:" + aapiumPort + "/wd/hub"), capabilites);
           // BaseTest.androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            BaseTest.androidDriver.manage().logs().getAvailableLogTypes();
            BaseTest.androidDriver.manage().logs().get("logcat");
        }
    }

    @BeforeClass
    public void StartReport() throws IOException {
        ExtentHtmlReporter reports=new ExtentHtmlReporter("./Reports/LoginLogoutTest.html");
        extend=new ExtentReports();
        extend.attachReporter(reports);

    }

    @BeforeMethod
    public void createExtendTest(ITestResult result){
        createTest(result.getMethod().getMethodName());
    }

    public static void logPassTest(String info){
        extentTest.log(Status.PASS,info);



    }

    public static void createTest(String TestName){
        extentTest = extend.createTest(TestName);


    }
    public static String getObject(String Data) throws IOException {
       Properties prop=new Properties();
        FileInputStream input= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\config.properties");
        prop.load(input);
        String data=prop.getProperty(Data);
        return data;
    }

    public static String Screenshot(String ImgName) throws IOException
    {

        File SrcFile = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);
        String Destination = System.getProperty("user.dir")+"/Reports/"+ImgName+".png";
      // String Destination = System.getProperty("user.dir")+"/Screenshot/"+ImgName+".png";
       // String Destination = System.getProperty("user.dir")+"/Reports/PassScreenshot/"+ImgName+".png";
        File FinalDestination = new File(Destination);
        FileUtils.copyFile(SrcFile, FinalDestination);
        return Destination;

    }

    public void ExtendReportPass(String TestName, String GetName, Throwable throwable) throws IOException {

        extentTest.log(Status.PASS, " Test Case Passed is " +GetName);
        extentTest.addScreenCaptureFromPath(TestName+".png");
//        System.out.println("1111111111111111111111111111111111111111111111111111111111111");
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println("2222222222222222222222222222222222222222222222222222222222222");
//        System.out.println(System.getProperty("user.dir")+"\\Screenshot\\"+TestName+".png");
//        System.out.println("3333333333333333333333333333333333333333333333333333333333333333");
//        extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Reports\\PassScreenshot\\"+GetName+".png");
//        extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshot\\"+TestName+".png","ScreenshotImage");

    }

    public void ExtendReportFail(String TestName, String GetName, String throwable) throws IOException {
//        ExtentTest logger = extend.createTest(TestName);
//        logger.log(Status.FAIL, " Test Case Failed is " +GetName);
//        logger.log(Status.FAIL, " Test Case Failed is " +throwable);
//        logger.addScreenCaptureFromPath(TestName+".png");
      //  logger.addScreenCaptureFromPath("C:\\eclipse\\ToolQA\\Screenshot\\"+TestName+".png");
     //   logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"/Screenshot/"+TestName+".png");

        ///   NEW CODE

        extentTest.log(Status.FAIL, " Test Case Failed is " +GetName);
        extentTest.log(Status.FAIL, " Test Case Failed is " +throwable);
        extentTest.addScreenCaptureFromPath(TestName+".png");
        //extentTest.addScreenCaptureFromPath("./Screenshot/"+TestName+".png");


        extend.flush();

    }
    public void CloseReport() {
        extend.flush();
        extend.close();
    }




    @AfterSuite
    public void stopAppium() {

        AppiumServiceHelper.stopService();
        logger.info("Appium Server Stop");
    }


    public void closeFailureAlertAndDialog() {

    }

    public void resetApp() {

    }

    public void goToHomePage() {

    }
}
