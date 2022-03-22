//package android.app.utils.core;
//
//import android.app.utils.testNG.MobileBaseTest;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import org.testng.annotations.BeforeClass;
//
//import java.io.IOException;
//
//public class ExtendReportProvider   {
//
//    public static ExtentSparkReporter extentSparkReporter;
//    public static ExtentTest extentTest;
//    public static ExtentReports extentReports;
//
//
//    public static void logInfo(String info){
//        extentTest.log(Status.INFO,info);
//    }
//
//    public static void logPassTest(String info){
//        extentTest.log(Status.PASS,info);
//
//    }
//    public static void logFailedTest(String info){
//        extentTest.log(Status.FAIL,info);
//    }
//
//    public static void createTest(String TestName){
//         extentTest = extentReports.createTest(TestName);
//    }
//
//    public static void StartReport() throws IOException {
//         extentSparkReporter = new ExtentSparkReporter("./Reports/LoginLogoutTest.html");
//        extentReports =new ExtentReports();
//        extentReports.attachReporter(extentSparkReporter);
//    }
//
////    public static void addScreenshotInReport() {
////        try {
////            String ScreenshotPath = MobileBaseTest.takeScreenshot();
////            extentTest.addScreenCaptureFromPath(ScreenshotPath);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//}
