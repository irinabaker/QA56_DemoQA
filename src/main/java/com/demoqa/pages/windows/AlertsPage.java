package com.demoqa.pages.windows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage verifyAlertWithTimer() {
        click(timerAlertButton);
        Assertions.assertTrue(isAlertPresent(5));
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage selectResult(String result) {
        click(confirmButton);

        if (result != null && result.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage verifyResult(String text) {
        Assertions.assertTrue(isContainsText(text, confirmResult));
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage sendMessageToAlert(String message) {
        clickWithJS(promtButton,0,100);

        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage verifyMessage(String text) {
        Assertions.assertTrue(isContainsText(text,promptResult));
        return this;
    }
}
