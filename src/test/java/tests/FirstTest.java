package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    AppiumDriver<MobileElement> driver;
    String url="https://cybertek-appium.s3.amazonaws.com/calculator.apk";

   @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps= new DesiredCapabilities();
        //caps.setCapability("deviceName","Pixel 3");
        caps.setCapability(DEVICE_NAME,"Pixel 3");
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","10");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("app",url);

        URL url =new URL("http://localhost:4723/wd/hub");
        //Chrome = ChromeDriver
        //Android=AndroidDriver
        //IOS = IOSDriver
       // WebElement ->> MobileElement -> AndroidElement /IOSElement
        //WebDriver -> RemoteWebDriver -> ChromeDriver
         //->AppiumDriver -> AndroidWebDriver/IOSDriver

        driver=new AndroidDriver<>(url,caps);
        driver.findElement(By.xpath("//*[@text='1']")).click();
        driver.findElement(By.xpath("//*[@text='5']")).click();
        driver.findElement(MobileBy.AccessibilityId("plus")).click();
        driver.findElement(By.xpath("//*[@text='6']")).click();
        driver.findElement(MobileBy.AccessibilityId("equals")).click();
        Thread.sleep(2000);

        String expected ="21";

        String actualResult=driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        Assertions.assertEquals(expected,actualResult,"result is not correct");
        driver.closeApp();

    }



}
