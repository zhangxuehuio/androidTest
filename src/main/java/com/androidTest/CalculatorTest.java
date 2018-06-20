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
 * ���Լ������Ĳ�������
 */
public class CalculatorTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //�����豸 �����Ϣ
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android emulator-5554");//�豸����
        capabilities.setCapability("automationName", "Appium");//���Կ������
        capabilities.setCapability("platformName", "Android");//����ƽ̨andorid
        capabilities.setCapability("platformVersion", "8.0");//����ƽ̨�İ汾�ȼ�
        capabilities.setCapability("appPackage", "com.android.calculator2");//����Ҫ����APP�İ���
        capabilities.setCapability("appActivity", ".Calculator");//����Ҫ����APP��Activity,ԭ��app��Ҫ��һ����(.)

        //�����豸
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        //ͨ��id����λ�ؼ�
        WebElement webElement1 = driver.findElement(By.id("com.android.calculator2:id/digit_1"));
        System.out.println("����    " + webElement1.getText());
        //����¼�
        webElement1.click();
        WebElement web = driver.findElement(By.id("com.android.calculator2:id/pad_numeric"));
        List<WebElement> webElement = web.findElements(By.className("android.widget.Button"));
        System.out.println("����    " + webElement.get(8).getText());
        webElement.get(8).click();
        WebElement webElement4 = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        System.out.println("����    " + webElement4.getText());
        webElement4.click();
        WebElement webElementDel = driver.findElement(By.id("com.android.calculator2:id/del"));
        System.out.println("����    " + webElementDel.getText());
        webElementDel.click();
        WebElement webElementAdd = driver.findElement(By.id("com.android.calculator2:id/op_add"));
        System.out.println("����    " + webElementAdd.getText());
        webElementAdd.click();
        WebElement webElement9 = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
        System.out.println("����    " + webElement9.getText());
        webElement9.click();
        //ͨ��Xpath ��λ��һ���ؼ�����ʽ��//android.view.ViewGroup/android.widget.Button
        WebElement webElement7 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.Button"));
        System.out.println("����    " + webElement7.getText());
        webElement7.click();
        //ͨ��androidUIAutomator����λ�ؼ���
        WebElement webElementJian = driver.findElementByAndroidUIAutomator("new UiSelector().description(\"minus\")");
        System.out.println("����    " + webElementJian.getText().toString());
        webElementJian.click();
        //ͨ��Xpath����λtextΪ8�Ŀؼ���
        WebElement webElement8 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.Button[contains(@text,'8')]"));
        System.out.println("����    " + webElement8.getText());
        webElement8.click();
//        WebElement webElementEq = driver.findElement(By.id("com.android.calculator2:id/eq"));
        //ͨ��content-desc ��λ�ؼ�
        WebElement webElementEq = driver.findElementByAccessibilityId("equals");
        System.out.println("����    " + webElementEq.getText());
        webElementEq.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        System.out.println("���Խ����" + result);
//        Assert.check(result.equals("22"));
        driver.quit();
    }
}
