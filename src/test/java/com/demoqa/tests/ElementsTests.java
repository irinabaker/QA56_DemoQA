package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.ButtonsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementsTests extends TestBase {

    SidePanel sidePanel;
    ButtonsPage buttons;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(driver);
        buttons = new ButtonsPage(driver);
        new HomePage(driver).selectElements();
    }

    @Test
    public void doubleClickTest() {
        sidePanel.selectButtons().hideIframes();
        buttons.doubleClick()
                .verifyDoubleClick("double click");
    }

    @Test
    public void rightClickTest() {
        sidePanel.selectButtons().hideIframes();
        buttons.rightClick()
                .verifyRightClick("right click");
    }
}
