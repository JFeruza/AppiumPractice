package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private static AppiumDriver<MobileElement> driver;
    private static URL url;
    private static DesiredCapabilities caps;

    private Driver() {}

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "Pixel 3");
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "10");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
            try {
                url = new URL("http://localhost:4723/wd/hub");
                driver = new AndroidDriver<>(url, caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Appium server URL is not valid!");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.closeApp();
            driver = null;
        }
    }



}
