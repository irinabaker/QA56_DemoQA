package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage enterData(String name, String email) {
        js.executeScript("document.getElementById('userName').value='" + name + "';");
        js.executeScript("document.getElementById('userEmail').value='" + email + "';");
        js.executeScript("document.getElementById('userEmail').style.border='5px solid red';");
        return this;
    }

    public TextBoxPage clickOnSubmit() {
        js.executeScript("document.querySelector('#submit').click();");
        js.executeScript("document.querySelector('#submit').style.backgroundColor='green';");
        return this;
    }

    public TextBoxPage refresh() {
        js.executeScript("history.go(0);");
        return this;
    }

    public TextBoxPage getInnerText() {
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        System.out.println("********************************************");
        return this;
    }

    public TextBoxPage verifyURL() {
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the website = " + url);
        System.out.println("*********************************************");
        return this;
    }

    public TextBoxPage navigateToNewWebsite() {
        js.executeScript("window.location='https://ilcarro.web.app'");
        return this;
    }

    public TextBoxPage verifyTitleOfNewPage() {
        String title = js.executeScript("return document.title;").toString();
        System.out.println("Title of new website = " + title);
        return this;
    }

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;

    public TextBoxPage enterPersonalData(String name, String email) {
        scrollWithJS(0,400);
        type(userName,name);
        type(userEmail,email);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage keyBoardEvent(String address) {

        type(currentAddress,address);
        Actions actions = new Actions(driver);
        //select current address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press TAB to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past current address to permanent address area
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        scrollWithJS(0,300);
        click(submit);
        return this;
    }

    @FindBy(css = ".border #currentAddress")
    WebElement currentAddressResult;
    @FindBy(css = ".border #permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage verifyCopyPastText() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assertions.assertEquals(current[1],permanent[1]);
        return this;
    }
}
