package org.Salt.Utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonLocators extends PageFactory {

    AllClasses objAll;

    public CommonLocators(AppiumDriver driver, WebDriver driverWeb) {
        objAll = new AllClasses(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
    }

    public WebElement elemLocator(By locatorType) {
        return PageFactory.getMobileDriver().findElement(locatorType);
    }

    public List<WebElement> list_ElemLocators(By locatorType) {
        return PageFactory.getMobileDriver().findElements(locatorType);
    }

    public WebElement elemLocator_Web(By locatorType) {
        return PageFactory.getWebDriver().findElement(locatorType);
    }

    public List<WebElement> list_ElemLocators_Web(By locatorType) {
        return PageFactory.getWebDriver().findElements(locatorType);
    }
}
