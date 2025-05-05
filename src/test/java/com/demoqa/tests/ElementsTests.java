package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.pages.elements.LinksPage;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.utils.MyArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ElementsTests extends TestBase {

    SidePanel sidePanel;
    ButtonsPage buttons;
    LinksPage links;
    TextBoxPage textBox;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(app.driver);
        buttons = new ButtonsPage(app.driver);
        links = new LinksPage(app.driver);
        textBox = new TextBoxPage(app.driver);
        new HomePage(app.driver).selectElements();
    }

    @Test
    @Tag("suite")
    public void doubleClickTest() {
        sidePanel.selectButtons().hideIframes();
        buttons.doubleClick()
                .verifyDoubleClick("double click");
    }

    @Test
    @Tag("suite")
    public void rightClickTest() {
        sidePanel.selectButtons().hideIframes();
        buttons.rightClick()
                .verifyRightClick("right click");
    }

    @Test
    public void getAllLinksTest() {
        sidePanel.selectLinks().hideIframes();
        links.getAllLinks();
    }

    @Test
    public void checkBrokenLinksTest() {
        sidePanel.selectBrokenLinksImages();
        links.checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
        sidePanel.selectBrokenLinksImages();
        links.checkBrokenImages();
    }

    @Test
    public void JSExecutorTest() {
        sidePanel.selectTextBox();
        new TextBoxPage(app.driver).enterData("Jamal Musiala","jamal@gm.com")
                .clickOnSubmit()
                .refresh()
                .getInnerText()
                .verifyURL()
                .navigateToNewWebsite()
                .verifyTitleOfNewPage()
        ;
    }

    @ParameterizedTest
    @MethodSource("personalData")
    public void parametrizationTest(String name, String email, String address) {
        sidePanel.selectTextBox().hideIframes();
        textBox.enterPersonalData(name,email)
                .keyBoardEvent(address)
                .verifyCopyPastText();
    }

    public static Stream<Arguments> personalData() {
        return Stream.of(
                arguments("Jamal Musiala","jamal@gm.com","Berlin"),
                arguments("Jamal Musiala","ja@gm.com","Berlin"),
                arguments("Jamal Musiala","jamallllllllllllllllllllllllllllllllllllllll@gm.com","Berlin")
        );
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void parametrizationTest2(String name, String email, String address) {
        sidePanel.selectTextBox().hideIframes();
        textBox.enterPersonalData(name,email)
                .keyBoardEvent(address)
                .verifyCopyPastText();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void parametrizationTest3(String name, String email, String address) {
     //   User user = User.builder().name(name).email(email).build();
        sidePanel.selectTextBox().hideIframes();
        textBox.enterPersonalData(name,email)
                .keyBoardEvent(address)
                .verifyCopyPastText();
    }
}
