package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoCompletePage extends BasePage {

    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "autoCompleteMultipleInput")
    WebElement autoCompleteMultipleInput;

    public AutoCompletePage autoComplete(String text) {
        scrollWithJS(0,300);

        autoCompleteMultipleInput.sendKeys("a");
        autoCompleteMultipleInput.sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }

    @FindBy(id = "autoCompleteMultipleContainer")
    WebElement autoCompleteMultipleContainer;

    public AutoCompletePage verifyAutoComplete(String color) {
        Assertions.assertTrue(isContainsText(color,autoCompleteMultipleContainer));
        return this;
    }
}
