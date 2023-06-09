package org.TREE.PageObjects.WebApplication;

import org.TREE.Utils.AllClasses;
import org.TREE.Utils.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JqueryElements extends PageFactory {
    AllClasses objAll;

    public JqueryElements(WebDriver driverWeb) {
        objAll = new AllClasses(PageFactory.getMobileDriver(), PageFactory.getWebDriver());

    }

    public WebElement navigation_Droppable() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("//a[contains(.,'Droppable')]"));
    }

    public WebElement navigation_Selectable() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("//a[contains(.,'Selectable')]"));
    }

    public WebElement navigation_Controlgroup() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("//a[contains(@href,'https://jqueryui.com/controlgroup/')]"));
    }

    public WebElement draggable_Item() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.id("draggable"));
    }

    public WebElement droppable_Item() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.id("droppable"));
    }

    public WebElement select_list_Option(String itemNumber) {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("//li[contains(.,'" + itemNumber + "')]"));
    }

    public WebElement controlGroup_Automatic() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("(//label[@for='transmission-automatic']/span)[1]"));
    }

    public WebElement controlGroup_Insurance() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("(//label[@for='insurance']/span)[1]"));
    }

    public WebElement controlGroup_Standard() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("(//label[@for='transmission-standard-v']/span)[1]"));
    }

    public WebElement controlGroup_Insurance_Rental() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("(//label[@for='insurance-v']/span)[1]"));
    }

    public WebElement controlGroup_NumberCars() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("//input[@id='vertical-spinner']"));
    }

    public WebElement controlGroup_Button_BookNow() {
        return objAll.getObjCommonLocators().elemLocator_Web(By.xpath("//button[@id='book']"));
    }

}
