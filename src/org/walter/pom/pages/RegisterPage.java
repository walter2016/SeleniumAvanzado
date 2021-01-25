package org.walter.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    By txtFirstName = By.name("firstName");
    By ddlCountry = By.name("country");
    By txtUserName = By.id("email");
    By txtPassword = By.name("password");
    By btnSubmit = By.xpath("//input[@type='image' and @name='register']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setFirstName(String strFirstName){
        driver.findElement(txtFirstName).sendKeys(strFirstName);
    }

    public void selectedCountry(String strCountry){
        new Select( driver.findElement(ddlCountry)).selectByVisibleText(strCountry);
    }




}
