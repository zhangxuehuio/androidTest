package com.androidTest;

import com.androidTest.Config.DriverConfig;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.tools.ant.taskdefs.Move;
import org.openqa.selenium.By;

import java.time.Duration;


public class EventTest {
    private static String elementId = "aa";

    public static void main(String[] args) {
        AndroidDriver driver = DriverConfig.getDriver();
        pressEvent(driver);
        longPressEvent(driver);
        tapEvent(driver);
    }

    /**
     * wait�¼�
     *
     * @param driver
     */
    private static void waitEvent(AndroidDriver driver) {
        TouchAction touchAction = new TouchAction(driver);
        //˫���¼�
        try {
            touchAction.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } /**
     * ����¼�
     *
     * @param driver
     */
    private static void moveToEvent(AndroidDriver driver) {
        TouchAction touchAction = new TouchAction(driver);
        PointOption option = new PointOption();
        //˫���¼�
        option.withCoordinates(0, 0).build();
        touchAction.moveTo(option).perform();//��ʼ
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        touchAction.tap(option).release();//����
    }

    /**
     * ����¼�
     *
     * @param driver
     */
    private static void tapEvent(AndroidDriver driver) {
        TouchAction touchAction = new TouchAction(driver);
        TapOptions option = new TapOptions();
        //˫���¼�
        option.withPosition(PointOption.point(111, 111))
                .withElement(ElementOption.element(driver.findElement(By.id(elementId))))
                .withTapsCount(2).build();
        touchAction.tap(option).perform();//��ʼ
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        touchAction.tap(option).release();//����
    }


    /**
     * �����¼�
     *
     * @param driver
     */
    private static void longPressEvent(AndroidDriver driver) {
        TouchAction touchAction = new TouchAction(driver);
        LongPressOptions option = new LongPressOptions();
        option.withPosition(PointOption.point(111, 111))
                .withElement(ElementOption.element(driver.findElement(By.id(elementId))))
                .withDuration(Duration.ofMillis(2000)).build();
        touchAction.longPress(option).perform();//��ʼ
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        touchAction.longPress(option).release();//����
    }

    /**
     * ��ѹ�¼�
     */
    private static void pressEvent(AndroidDriver driver) {
        TouchAction touchAction = new TouchAction(driver);
        PointOption option = new PointOption();
        option.withCoordinates(111, 111).build();
        touchAction.press(option).perform();//��ʼ
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        touchAction.press(option).release();//����
    }


}
