package com.demoqa.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    public WebDriver driver;

    public static JavascriptExecutor js;

    public static SoftAssertions softly;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
        softly = new SoftAssertions();
    }

    public void scrollWithJS(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y +")");
    }

    public void clickWithJS(WebElement element, int x, int y) {
        scrollWithJS(x,y);
        click(element);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isAlertPresent(int time) {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        }
        return true;
    }

    public boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public void switchToNextWindow(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException exception) {
            exception.getMessage();
            return false;
        }
    }

    public String getValueDomAttribute(String name, WebElement element) {
        return element.getDomAttribute(name);
    }

    public void hideIframes() {
        pause(1000);
        js.executeScript("document.getElementById('fixedban').style.display='none';");
        js.executeScript("document.getElementById('fixedban').style.display='none';");
        js.executeScript("document.querySelector('footer').style.display='none';");
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void verifyLinks(String url) {

        try {
            URL linkUrl = new URL(url);

            //create URL connection and get response code
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if (connection.getResponseCode() >= 400) {
             //   System.out.println(url + " - " + connection.getResponseMessage() + "is a broken link");
                softly.fail(url + " - " + connection.getResponseMessage() + "is a broken link");
            } else {
              //  System.out.println(url + " - " + connection.getResponseMessage());
                softly.assertThat(connection.getResponseCode()).isLessThan(400);
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() + " ERROR occurred");
        }
        softly.assertAll();
    }
}
