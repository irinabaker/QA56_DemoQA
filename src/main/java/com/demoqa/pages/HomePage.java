package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card:nth-child(3)")
    WebElement alertsFrameWindows;

    public SidePanel selectAlertsFrameWindows() {
        clickWithJS(alertsFrameWindows,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(4)")
    WebElement widgets;

    public SidePanel selectWidgets() {
        clickWithJS(widgets,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(5)")
    WebElement interactions;

    public SidePanel selectInteractions() {
        clickWithJS(interactions,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(1)")
    WebElement elements;

    public SidePanel selectElements() {
        clickWithJS(elements,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".card:nth-child(2)")
    WebElement forms;

    public SidePanel selectForms() {
        clickWithJS(forms,0,300);
        return new SidePanel(driver);
    }
}
