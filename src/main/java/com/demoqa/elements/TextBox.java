package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox {

    WebDriver driver;

    @BeforeTest
    void TextBoxTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    void fillFullName() {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Ayzada");
    }

    @Test
    void fillEmail() {
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("ayzada@example.com");
    }

    @Test
    void fillCurrentAddress() {
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Street, City, Country");
    }

    @Test
    void fillPermanentAddress() {
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Yunusalieva Street, Bishkek Town");


        driver.close();
            driver.quit();
        }
    }




