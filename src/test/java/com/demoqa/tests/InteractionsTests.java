package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.interactions.DroppablePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InteractionsTests extends TestBase {

    SidePanel sidePanel;
    DroppablePage droppable;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(driver);
        droppable = new DroppablePage(driver);
        new HomePage(driver).selectInteractions();
    }

    @Test
    public void actionDragMeTest() {
        sidePanel.selectDroppable().hideIframes();
        droppable.actionDragMe()
                .verifyDropped("Dropped!");
    }

    @Test
    public void actionDragMeByTest() {
        sidePanel.selectDroppable();
        droppable.actionDragMeBy(0,50)
                .verifyDropped("Dropped!");
    }
}
