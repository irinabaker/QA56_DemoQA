package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[.='Main Item 2']")
    WebElement mainItem2;
    @FindBy(xpath = "//*[.='SUB SUB LIST »']")
    WebElement suSubList;
    @FindBy(xpath = "//*[.='Sub Sub Item 1']")
    WebElement subItem1;

    public MenuPage selectSubMenu() {
        pause(1000);

        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        actions.moveToElement(suSubList).perform();

        return this;
    }

    public MenuPage verifySubMenu() {
        Assertions.assertTrue(isElementVisible(subItem1));
        return this;
    }

}
