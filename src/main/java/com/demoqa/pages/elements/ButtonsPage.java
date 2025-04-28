package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    public ButtonsPage doubleClick() {
        pause(500);
        scrollWithJS(0,300);
        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return this;
    }

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    public ButtonsPage verifyDoubleClick(String text) {
        Assertions.assertTrue(isContainsText(text,doubleClickMessage));
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClick() {
        pause(500);
        scrollWithJS(0,400);

        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage verifyRightClick(String text) {
        Assertions.assertTrue(isContainsText(text,rightClickMessage));
        return this;
    }
}
