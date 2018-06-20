package com.androidTest;

import com.sun.tools.javac.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.rmi.runtime.Log;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 测试计算器的测试用例
 */
public class CalculatorTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //配置设备 相关信息
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android emulator-5554");//设备名称
        capabilities.setCapability("automationName", "Appium");//测试框架名称
        capabilities.setCapability("platformName", "Android");//测试平台andorid
        capabilities.setCapability("platformVersion", "8.0");//测试平台的版本等级
        capabilities.setCapability("appPackage", "com.android.calculator2");//设置要测试APP的包名
        capabilities.setCapability("appActivity", ".Calculator");//设置要测试APP的Activity,原生app需要加一个点(.)

        //连接设备
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        //通过id，定位控件
        WebElement webElement1 = driver.findElement(By.id("com.android.calculator2:id/digit_1"));
        System.out.println("按键    " + webElement1.getText());
        //点击事件
        webElement1.click();
        WebElement web = driver.findElement(By.id("com.android.calculator2:id/pad_numeric"));
        List<WebElement> webElement = web.findElements(By.className("android.widget.Button"));
        System.out.println("按键    " + webElement.get(8).getText());
        webElement.get(8).click();
        WebElement webElement4 = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        System.out.println("按键    " + webElement4.getText());
        webElement4.click();
        WebElement webElementDel = driver.findElement(By.id("com.android.calculator2:id/del"));
        System.out.println("按键    " + webElementDel.getText());
        webElementDel.click();
        WebElement webElementAdd = driver.findElement(By.id("com.android.calculator2:id/op_add"));
        System.out.println("按键    " + webElementAdd.getText());
        webElementAdd.click();
        WebElement webElement9 = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
        System.out.println("按键    " + webElement9.getText());
        webElement9.click();
        //通过Xpath 定位第一个控件。格式：//android.view.ViewGroup/android.widget.Button
        WebElement webElement7 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.Button"));
        System.out.println("按键    " + webElement7.getText());
        webElement7.click();
        //通过androidUIAutomator，定位控件，
        WebElement webElementJian = driver.findElementByAndroidUIAutomator("new UiSelector().description(\"minus\")");
        System.out.println("按键    " + webElementJian.getText().toString());
        webElementJian.click();
        //通过Xpath，定位text为8的控件。
        WebElement webElement8 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.Button[contains(@text,'8')]"));
        System.out.println("按键    " + webElement8.getText());
        webElement8.click();
//        WebElement webElementEq = driver.findElement(By.id("com.android.calculator2:id/eq"));
        //通过content-desc 定位控件
        WebElement webElementEq = driver.findElementByAccessibilityId("equals");
        System.out.println("按键    " + webElementEq.getText());
        webElementEq.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        System.out.println("测试结果：" + result);
//        Assert.check(result.equals("22"));
        driver.quit();
    }
}
