package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String color) {

        Select select = new Select(oldSelectMenu);

        select.selectByVisibleText(color);
        return this;
    }

    public SelectMenuPage verifyColor() {
        String firstSelectedOption = new Select(oldSelectMenu).getFirstSelectedOption().getText();
        Assertions.assertTrue(isContainsText(firstSelectedOption,oldSelectMenu));
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement selectInput;

    @FindBy(css = "html")
    WebElement space;

    public SelectMenuPage multiSelect(String[] colors) {

        for (String text: colors) {
            selectInput.sendKeys(text);
            selectInput.sendKeys(Keys.ENTER);
        }
        click(space);
        return this;
    }

    public SelectMenuPage verifyMultiSelect(String[] colors) {
        for (String text: colors) {
            WebElement element = driver.findElement(By.xpath("//*[.='" + text + "']"));
            Assertions.assertTrue(isContainsText(text,element));
        }
        return this;
    }

    public SelectMenuPage standardMultiSelect(String car, String color) {
        WebElement selectedCar = driver.findElement(By.cssSelector("[value='" + car + "']"));
        click(selectedCar);
    //    System.out.println(selectedCar.getCssValue("background-color"));
           Assertions.assertTrue(selectedCar.getCssValue("background-color").contains(color));
        return this;
    }
}

//   [background-color='rgba(25, 103, 210, 1)']
