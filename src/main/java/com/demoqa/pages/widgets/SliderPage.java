package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".range-slider")
    WebElement sliderContainer;

    public SliderPage moveSliderToHorizontalDirection(int x, int y) {
        pause(1000);
        scrollWithJS(0,200);

        new Actions(driver).dragAndDropBy(sliderContainer, x, y).perform();
        return this;
    }

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public SliderPage verifySliderValue(String number) {
        Assertions.assertEquals(getValueDomAttribute("value", sliderValue),number);
        return this;
    }
}
