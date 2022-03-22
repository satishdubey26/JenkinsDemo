package android.app.utils.testNG;

import android.app.utils.core.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Customlistner extends MobileBaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            Screenshot(result.getMethod().getMethodName());
        } catch (IOException e) {

            e.printStackTrace();
        }
        try {
            ExtendReportPass(result.getMethod().getMethodName(), result.getName(), result.getThrowable());
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {

        try {
            Screenshot(result.getMethod().getMethodName());
        } catch (IOException e) {

            e.printStackTrace();
        }
        try {
            ExtendReportFail(result.getMethod().getMethodName(), result.getName(), result.getThrowable().getMessage());
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }



}
