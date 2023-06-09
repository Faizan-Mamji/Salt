package org.TREE.Utils;

import io.appium.java_client.AppiumDriver;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageFactory {
    Actions ac;
    AllClasses objAll;
    int getSIze;
    public Boolean elementPresent;
    String dateName, getTextValue;


    public CommonMethods(AppiumDriver driver, WebDriver driverWeb) {
        objAll = new AllClasses(PageFactory.getMobileDriver(), PageFactory.getWebDriver());
    }

    public static void navigate_Application(String urlKey) {
        PageFactory.getWebDriver().navigate().to(urlKey);
    }

    public void navigate_Back(int loopcount) {
        for (int i = 1; i <= loopcount; i++) {
            PageFactory.getMobileDriver().navigate().back();
        }
    }

    public void sendKeysّ(WebElement elem, String sendText) {
        elem.sendKeys(sendText);
    }

    public void click_Enter(WebElement elem) {
        elem.sendKeys(Keys.RETURN);
    }

    public String element_GetText(WebElement elem) {
        getTextValue = elem.getText().trim();
        return getTextValue;
    }

    public void clear_text(WebElement elem) {
        elem.clear();
    }

    public void click_Element(WebElement elem) {
        elem.click();
    }

    public String getText_Attribute(WebElement elem, String attributeName) {
        return elem.getAttribute(attributeName).trim();
    }

    public void screenshotCapturing_MobileApp(String fileName) {
        dateName = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss").format(new Date());

        try {
            TimeUnit.SECONDS.sleep(1);
            TakesScreenshot ts = (TakesScreenshot) PageFactory.getMobileDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            System.out.println(fileName + "/" + dateName + ".png");
            FileUtils.copyFile(source, new File(fileName + "/" + dateName + ".png"));

        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("Screenshot is taken successfully!");
    }

    public void screenshotCapturing_WebApp(String fileName) {
        dateName = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss").format(new Date());

        try {
            TimeUnit.SECONDS.sleep(1);
            TakesScreenshot ts = (TakesScreenshot) PageFactory.getWebDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            System.out.println(fileName + "/" + dateName + ".png");
            FileUtils.copyFile(source, new File(fileName + "/" + dateName + ".png"));

        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("Screenshot is taken successfully!");
    }

    public static void assert_VerificationText(String actualText, String expetcedText) {
        try {
            Assert.assertEquals(actualText, expetcedText);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public Boolean checkELementExist_Mobile(List<WebElement> locatorType) {
        try {
            elementPresent = locatorType.size() > 0;
        } catch (Exception ex) {
            return false;
        }
        return elementPresent;
    }

    public static void wait_For_Element(int duration) {
        try {
            TimeUnit.SECONDS.sleep(duration);

        } catch (Exception ex) {
            ex.getMessage();
        }

    }

    public static void element_WebDriverWait_Visibility_Mobile(By locator) {
        new WebDriverWait(PageFactory.getMobileDriver(), Duration.ofSeconds(Integer.parseInt(PropertyReader.getConfigValue(configFile, "webDriverWait")))).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static RequestSpecification common_Headers(String baseUrl) {
        return RestAssured.given().relaxedHTTPSValidation()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .header("Accept-Language", "");
    }

    public static JsonPath convertToJson(String Response) {
        JsonPath js = new JsonPath(Response);
        return js;
    }

    public static String post_Payload() {
        {
            return "{\n" +
                    "   \"name\":\"Bryant\",\n" +
                    "   \"job\":\"BA\"\n" +
                    "}";
        }
    }
}
