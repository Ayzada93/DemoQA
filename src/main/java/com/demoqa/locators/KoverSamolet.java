package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class KoverSamolet {
    @Test
    void foodTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
      WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
        WebElement chooseLink= driver.findElement(By.xpath("/html/body/section[3]/div/div/div[2]/div[1]/a/img"));
       chooseLink.click();

        WebElement arzuFood= driver.findElement(By.xpath("//*[@id=\"WWMainPage\"]/div[2]/div[45]/div/div[2]/div[2]/a"));
        arzuFood.click();
        WebElement chooseFood= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/article[2]/div/div/div[1]/div[16]/div/div[2]/form/button"));
        chooseFood.click();

        driver.get("https://dostavka312.kg/cart");


        WebElement fullNameInput = driver.findElement(By.name("name"));
        fullNameInput.sendKeys("Айзада");

        WebElement homeLink= driver.findElement(By.xpath("//input[@placeholder='Адрес']"));
        homeLink.sendKeys("Абдырахманова 45");

        WebElement PhoneLink= driver.findElement(By.xpath("//input[@placeholder='Ваш телефон']"));
        PhoneLink.sendKeys("0555843556");

        WebElement moneyLink= driver.findElement(By.xpath("//input[@placeholder='Сдача с']"));
        moneyLink.sendKeys("5000");

        WebElement makeOrder= driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/button[1]"));
        makeOrder.click();

    }
}
