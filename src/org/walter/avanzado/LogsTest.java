package org.walter.avanzado;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogsTest {
    WebDriver driver;
    String baseUrl = "http://healthunify.com/bmicalculator";
    Logger log = Logger.getLogger(LogsTest.class);


    @BeforeClass
    public void initializeComponent(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\resources\\log.properties");
    }


    @Test
    public void launchBrowser(){
        try{
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);
            log.info("Opening website: " + baseUrl);
        }catch (WebDriverException we){
            log.error("WebDriver Failed: " + we.getMessage() );
        }catch (Exception e){
            log.fatal(e.getMessage());

        }
    }

    @Test(dependsOnMethods = {"BMICalculator"} )
    public  void tearDown (){
        driver.quit();
        log.info("Browser closed!");
    }


    @Test(dependsOnMethods = {"launchBrowser"} )
    public void BMICalculator(){
        try{
            log.info("Entering weight");
            driver.findElement(By.name("wg")).sendKeys("87");
            log.info("Selected Kilograms");
            new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("kilograms");
            log.info("selecting height in feet");
            driver.findElement(By.name("opt2")).sendKeys("5");
            log.info("selecting height in inchs");
            driver.findElement(By.name("opt3")).sendKeys("10");
            log.info("Clicking on Calculate");
            driver.findElement(By.name("cc")).click();

            String SiUnit = driver.findElement(By.name("si")).getAttribute("value");
            String USUnit = driver.findElement(By.name("us")).getAttribute("value");
            String UKUnit = driver.findElement(By.name("uk")).getAttribute("value");
            String note = driver.findElement(By.name("desc")).getAttribute("value");

            log.info("SI unit" + SiUnit);
            log.info("US unit" + USUnit);
            log.info("UK unit" + UKUnit);
            log.info("Description" + SiUnit);

        }catch (NoSuchElementException ne){
                log.error("WebElement not found " +ne.getMessage());
        }catch (WebDriverException we){
            log.error("WebDriver failed: " +we.getMessage());
        }catch (Exception e){
            log.fatal(e.getMessage());
        }

    }

}
