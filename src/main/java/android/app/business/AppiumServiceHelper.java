package android.app.business;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServiceHelper {

    private static AppiumServiceBuilder builder = new AppiumServiceBuilder();
    private static AppiumDriverLocalService appiumLocalService;

    public static AppiumDriverLocalService startDefaultService(int portNumber)
            throws Exception {
        return startService(builder.usingPort(portNumber));
    }

    /**
     * Starts the Appium service with the specified serviceBuilder.
     *
     * @param serviceBuilder The service builder object created with the AppiumServiceBuilder class.
     * @return The AppiumDriverLocalService object pertaining to the created Appium service instance.
     * @throws Exception in case any failure is encountered in starting the Appium service.
     */
    public static AppiumDriverLocalService startService(
            AppiumServiceBuilder serviceBuilder) throws Exception {

        if (isServiceRunning()) {
            return getAppiumLocalService();
        }
        appiumLocalService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumLocalService.start();
        if (!appiumLocalService.isRunning())
            throw new Exception(
                    "Appium Service not started. Please check the settings");
        return appiumLocalService;

    }

    /**
     * Gets the Appium service object.
     *
     * @return The Appium service object.
     */
    public static AppiumDriverLocalService getAppiumLocalService() {
        return appiumLocalService;
    }

    /**
     * Returns with a boolean status indicating whether the Appium service is running or not.
     *
     * @return true if the Appium service is running; false otherwise or if the service is null.
     */
    public static boolean isServiceRunning() {
        return appiumLocalService != null && appiumLocalService.isRunning();
    }

    /**
     * Stops the Appium service if it is running.
     */
    public static void stopService() {
        if (isServiceRunning())
            appiumLocalService.stop();
    }

}
