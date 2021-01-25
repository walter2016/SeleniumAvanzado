package org.walter.avanzado;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RoboApi {
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
    WebDriver driver;

    @Test
    public void robotAPITest() throws AWTException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", chromePath);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://plantillaspowerpoint.online/creativas/plantilla-powerpoint-aldebaran/");
        driver.findElement(By.linkText("DESCARGAR PPTX")).click();
        Robot robot = new Robot();

        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        for (int i=0; i<=2;i++){
            robot.keyPress(KeyEvent.VK_TAB);
        }

        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        driver.quit();

    }

}
