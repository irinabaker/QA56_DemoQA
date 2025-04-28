package com.demoqa.pages.windows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "windowButton")
    WebElement windowButton;

    public BrowserWindowsPage switchToNewWindow(int index) {
        click(windowButton);
        switchToNextWindow(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public BrowserWindowsPage verifyNewWindowTitle(String title) {
        Assertions.assertTrue(isContainsText(title,sampleHeading));
        return this;
    }
}
