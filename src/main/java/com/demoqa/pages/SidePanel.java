package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.interactions.DroppablePage;
import com.demoqa.pages.widgets.*;
import com.demoqa.pages.windows.AlertsPage;
import com.demoqa.pages.windows.BrowserWindowsPage;
import com.demoqa.pages.windows.FramePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJS(alerts,0,200);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BrowserWindowsPage selectBrowserWindows() {
        clickWithJS(browserWindows,0,200);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public FramePage selectFrame() {
        clickWithJS(frames,0,300);
        return new FramePage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public FramePage selectNestedFrames() {
        clickWithJS(nestedFrames,0,300);
        return new FramePage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage getSelectMenu() {
        clickWithJS(selectMenu,0,800);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage getMenu() {
        clickWithJS(menu,0,800);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        clickWithJS(slider,0,600);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public ToolTipsPage selectToolTips() {
        clickWithJS(toolTips,0,600);
        return new ToolTipsPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;

    public DroppablePage selectDroppable() {
        clickWithJS(droppable,0,800);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public SidePanel selectButtons() {
        clickWithJS(buttons,0,300);
        return this;
    }

    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoComplete;

    public AutoCompletePage selectAutoComplete() {
        clickWithJS(autoComplete,0,600);
        return new AutoCompletePage(driver);
    }
}
