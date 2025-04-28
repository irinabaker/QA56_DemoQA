package com.demoqa.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {

   public WebDriver driver;

    //@BeforeMethod == @BeforeEach
    //@BeforeSuite == @BeforeAll

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
}
