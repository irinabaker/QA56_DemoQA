package com.demoqa.pages.interactions;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        pause(1000);
        scrollWithJS(0,400);
        new Actions(driver).dragAndDrop(dragMe,dropHere).perform();
        return this;
    }

    public DroppablePage verifyDropped(String text) {
        Assertions.assertTrue(isContainsText(text,dropHere));
        return this;
    }

    public DroppablePage actionDragMeBy(int x, int y) {
        pause(1000);
        scrollWithJS(0,400);

        //get coordinates dragMe(from) and print
        int xOffset = dragMe.getLocation().getX();
        int yOffset = dragMe.getLocation().getY();
        System.out.println("xOffset --> " + xOffset + " yOffset --> " + yOffset) ;

        //get coordinates dropHere(to) and print
        int xOffset1 = dropHere.getLocation().getX();
        int yOffset1 = dropHere.getLocation().getY();
        System.out.println("xOffset1 --> " + xOffset1 + " yOffset1 --> " + yOffset1);

        //find the difference
        xOffset1 = (xOffset1 - xOffset) + x;
        yOffset1 = (yOffset1 - yOffset) + y;

        new Actions(driver).dragAndDropBy(dragMe,xOffset1,yOffset1).perform();
        return this;
    }
}
