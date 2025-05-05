package com.demoqa.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;


public class MyListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeGet(WebDriver driver, String url) {
        logger.info("Open URL - {}",url);
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        logger.info("Page title - {}",result);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error("Something went wrong!!!");
        logger.error("================================");
        logger.error("Method {}", method);
        logger.error("================================");
        logger.error("Target {}",target);
        logger.error("================================");
        logger.error("Exception {}",e.getMessage());

        int i = new Random().nextInt(1000) + 1000;
        String link= "screenshots/screen_" + i + ".png";
        logger.info("Screen with error --> " + link);

        WebDriver driver = (ChromeDriver) target;
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(tmp,new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("We found element {}", result.toString());
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        logger.info("We found elements {}",result.size());
    }

    @Override
    public void beforeClick(WebElement element) {
        logger.info("We click on element {}",element);
    }
}

//git init
// git status
//git add .
// git commit -m "Updated"
//git push
