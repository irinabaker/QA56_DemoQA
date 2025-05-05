package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class WidgetsTests extends TestBase {

    SidePanel sidePanel;
    SelectMenuPage selectMenu;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(app.driver);
        selectMenu = new SelectMenuPage(app.driver);
        new HomePage(app.driver).selectWidgets();
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
        new MenuPage(app.driver).selectSubMenu()
                .verifySubMenu();
    }

    @Test
    public void sliderTest() {
        sidePanel.selectSlider().hideIframes();
        new SliderPage(app.driver).moveSliderToHorizontalDirection(220,0)
                .verifySliderValue("100");
    }

    @Test
    public void toolTipsTest() {
        sidePanel.selectToolTips().hideIframes();
        new ToolTipsPage(app.driver).hoverToolTips()
                .verifyToolTips("buttonToolTip");
    }

    @Test
    @Tag("suite")
    public void autoCompleteTest() {
        sidePanel.selectAutoComplete().hideIframes();
        new AutoCompletePage(app.driver).autoComplete("a")
                .verifyAutoComplete("Magenta");
    }

}
