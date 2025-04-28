package com.demoqa.pages.windows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public FramePage returnListOfIframes() {
        System.out.println("The total number of iframes are " + iframes.size());
        return this;
    }

    public FramePage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public FramePage verifyIframeByTitle(String title) {
        Assertions.assertTrue(isContainsText(title,sampleHeading));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public FramePage switchToIframeById() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public FramePage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(css = ".text-center")
    WebElement frameTitle;

    public FramePage verifyMainPageTitle(String title) {
        Assertions.assertTrue(isContainsText(title,frameTitle));
        return this;
    }

    @FindBy(tagName = "body")
    WebElement body;

    public FramePage handleNestedIframes() {
        //switch to parent iframe
        driver.switchTo().frame(frame1);
        System.out.println("Iframe is " + body.getText());
        //switch to child iframe
        driver.switchTo().frame(0);
        System.out.println("Iframe is " + body.getText());
        //switch to parent iframe
        driver.switchTo().parentFrame();
        System.out.println("Iframe is " + body.getText());
        return this;
    }
}
