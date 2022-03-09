package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EtsyTest {

    String email = "areatha@uspeakw.com";
    String password = "Cybertek2020";


    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 3");
        capabilities.setCapability(PLATFORM_NAME, "Android");
        capabilities.setCapability(PLATFORM_VERSION, "10");
        capabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(APP, "https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, capabilities);
        //Thread.sleep(2000);

    }


    @Test
    public void test1() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.id("com.etsy.android:id/btn_link")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.etsy.android:id/edit_username")).sendKeys(email);
        driver.findElement(By.id("com.etsy.android:id/edit_password")).sendKeys(password);
        driver.findElement(By.id("com.etsy.android:id/button_signin")).click();
        Thread.sleep(2000);

    }

    @AfterEach
    public void tearDown(){
        driver.closeApp();
        driver=null;
    }


}
