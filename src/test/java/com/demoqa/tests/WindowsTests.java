package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.windows.AlertsPage;
import com.demoqa.pages.windows.BrowserWindowsPage;
import com.demoqa.pages.windows.FramePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WindowsTests extends TestBase {

    SidePanel sidePanel;
    AlertsPage alerts;
    FramePage frame;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(app.driver);
        alerts = new AlertsPage(app.driver);
        frame = new FramePage(app.driver);
        new HomePage(app.driver).selectAlertsFrameWindows();
    }

    @Test
    public void alertWaitTest() {
       sidePanel.selectAlerts();
        alerts.verifyAlertWithTimer();
    }

    @Test
    @DisplayName("Verify to - 'Cancel' is displayed")
    public void alertWithSelectTest() {
        sidePanel.selectAlerts();
        alerts.selectResult("Cancel").verifyResult("Cancel");
    }

    @Test
    @DisplayName("Verify to - Text you entered is displayed")
    public void sendMessageToAlertTest() {
        sidePanel.selectAlerts();
        alerts.sendMessageToAlert("Hello world!").verifyMessage("Hello world!");
    }

    @Test
    @DisplayName("Verify to - Text in new Window is displayed")
    public void newWindowHandlesTest() {
        sidePanel.selectBrowserWindows();
        new BrowserWindowsPage(app.driver)
                .switchToNewWindow(1)
                .verifyNewWindowTitle("This is a sample page");
    }

    @Test
    @DisplayName("Verify number of iframes on the page and Switch to iframe by index")
    public void iframeTest() {
        sidePanel.selectFrame();
        frame.returnListOfIframes()
                .switchToIframeByIndex(1)
                .verifyIframeByTitle("This is a sample page");
    }

    @Test
    @DisplayName("Switch to iframe by id")
    public void  iframeTest2() {
        sidePanel.selectFrame();
        frame.switchToIframeById()
                .verifyIframeByTitle("This is a sample page")
                .switchToMainPage()
                .verifyMainPageTitle("Frame");
    }

    @Test
    public void nestedIframesTest() {
        sidePanel.selectNestedFrames();
        frame.handleNestedIframes();
    }
}
