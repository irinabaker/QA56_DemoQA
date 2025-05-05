package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public LinksPage getAllLinks() {
        String url = "";

        System.out.println("Total links on the page: " + allLinks.size());

        Iterator<WebElement> iterator = allLinks.iterator();

        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
            System.out.println("**********************************************");
        }
        return this;
    }

    public LinksPage checkBrokenLinks() {

        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getDomAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public LinksPage checkBrokenImages() {
        System.out.println("Total images on the page: " + images.size());

        for (int i = 0; i <images.size(); i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");
            verifyLinks(imageUrl);

            try {
                boolean imageDisplayed = (Boolean) js
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);",image);
                if (imageDisplayed) {
                    softly.assertThat(imageDisplayed);
                } else {
                    softly.fail("Broken image is " + imageUrl);
                }
            } catch (Exception e) {
                System.out.println("ERROR occurred");
            }
        }
        softly.assertAll();
        return this;
    }
}
