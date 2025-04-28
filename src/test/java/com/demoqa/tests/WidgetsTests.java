package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WidgetsTests extends TestBase {

    SidePanel sidePanel;
    SelectMenuPage selectMenu;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(driver);
        selectMenu = new SelectMenuPage(driver);
        new HomePage(driver).selectWidgets();
    }

    @Test
    public void oldStyleSelectTest() {
        sidePanel.getSelectMenu();
        selectMenu.selectOldStyle("Blue")
                .verifyColor();
    }

    @Test
    public void multiplyDropDownTest() {
        sidePanel.getSelectMenu();
        selectMenu.multiSelect(new String[]{"Red","Green"})
                .verifyMultiSelect(new String[]{"Red","Green"});
    }

    @Test
    public void standardMultiSelectTest() {
        sidePanel.getSelectMenu();
        selectMenu.standardMultiSelect("saab","rgba(25, 103, 210, 1)");
    }

    @Test
    public void selectSubMenuTest() {
        sidePanel.getMenu();
        new MenuPage(driver).selectSubMenu()
                .verifySubMenu();
    }

    @Test
    public void sliderTest() {
        sidePanel.selectSlider().hideIframes();
        new SliderPage(driver).moveSliderToHorizontalDirection(220,0)
                .verifySliderValue("100");
    }

    @Test
    public void toolTipsTest() {
        sidePanel.selectToolTips().hideIframes();
        new ToolTipsPage(driver).hoverToolTips()
                .verifyToolTips("buttonToolTip");
    }

    @Test
    public void autoCompleteTest() {
        sidePanel.selectAutoComplete().hideIframes();
        new AutoCompletePage(driver).autoComplete("a")
                .verifyAutoComplete("Magenta");
    }

}
