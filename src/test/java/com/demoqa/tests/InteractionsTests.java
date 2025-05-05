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
        sidePanel = new SidePanel(app.driver);
        droppable = new DroppablePage(app.driver);
        new HomePage(app.driver).selectInteractions();
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

// mvn clean test -Dtest=InteractionsTests#actionDragMeTest - run method
// mvn clean test -Dtest=InteractionsTests - run class
// mvn clean test -Dgroups=suite - run with tag


