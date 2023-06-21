package org.Salt.BusinessLayer;

import io.qameta.allure.Step;
import org.Salt.Utils.AllClasses;
import org.Salt.Utils.CommonMethods;
import org.Salt.Utils.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.time.Duration;

public class Web_BusinessLogic extends PageFactory {
    AllClasses objAll;
    Logger log = LogManager.getLogger(Mobile_BusinessLogic.class);
    Actions ac;

    public Web_BusinessLogic(WebDriver driverWeb) {
        objAll = new AllClasses(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
        ac = new Actions(PageFactory.getWebDriver());
    }

    @Step("Drag & Drop Action performed!")
    public void Testcase1_Verify_Element_Droppable() {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjJqueryElements().navigation_Droppable());
            log.info("Droppable click successfully from left navigation!");
            CommonMethods.wait_For_Element(2);
            PageFactory.getWebDriver().switchTo().frame(0);
            ac.dragAndDrop(objAll.getObjJqueryElements().draggable_Item(), objAll.getObjJqueryElements().droppable_Item()).release().perform();
            log.info("Element drop off to destination!");
            CommonMethods.wait_For_Element(1);
            PageFactory.getWebDriver().switchTo().defaultContent();
        } catch (Exception ex) {
            log.info("Tc failed - Testcase1_Verify_Element_Droppable");
            Assert.fail("Issue in Testcase1_Verify_Element_Droppable -" + ex.getMessage());
        }
    }

    @Step("Select mutiple list elements!")
    public void Testcase2_Verify_Element_Selectable(String item1, String item3, String item7) {
        try {
            objAll.getObjCommonMethods().click_Element(objAll.getObjJqueryElements().navigation_Selectable());
            log.info("Selectable click successfully from left navigation!");
            CommonMethods.wait_For_Element(2);
            PageFactory.getWebDriver().switchTo().frame(0);
            ac.keyDown(Keys.COMMAND).click(objAll.getObjJqueryElements().select_list_Option(item1))
                    .pause(Duration.ofSeconds(1))
                    .click(objAll.getObjJqueryElements().select_list_Option(item3))
                    .pause(Duration.ofSeconds(1))
                    .click(objAll.getObjJqueryElements().select_list_Option(item7)).release().perform();
            CommonMethods.wait_For_Element(2);
            PageFactory.getWebDriver().switchTo().defaultContent();
        } catch (Exception ex) {
            log.info("Tc failed - Testcase1_Verify_Element_Droppable");
            Assert.fail("Issue in Testcase1_Verify_Element_Droppable -" + ex.getMessage());
        }
    }

    @Step("Select multiple types from control group!")
    public void Testcase3_Verify_ControlGroup_Actions() {
        try {
            CommonMethods.navigate_Application("https://jqueryui.com/controlgroup/");
            log.info("Control Group click successfully from left navigation!");
            CommonMethods.wait_For_Element(2);
            PageFactory.getWebDriver().switchTo().frame(0);
            objAll.getObjCommonMethods().click_Element(objAll.getObjJqueryElements().controlGroup_Automatic());
            objAll.getObjCommonMethods().click_Element(objAll.getObjJqueryElements().controlGroup_Insurance());
            objAll.getObjCommonMethods().click_Element(objAll.getObjJqueryElements().controlGroup_Standard());
            objAll.getObjCommonMethods().click_Element(objAll.getObjJqueryElements().controlGroup_Insurance_Rental());
            objAll.getObjCommonMethods().click_Element(objAll.getObjJqueryElements().controlGroup_Button_BookNow());
            PageFactory.getWebDriver().switchTo().defaultContent();
        } catch (Exception ex) {
            log.info("Tc failed - Testcase1_Verify_Element_Droppable");
            Assert.fail("Issue in Testcase1_Verify_Element_Droppable -" + ex.getMessage());
        }
    }
}
