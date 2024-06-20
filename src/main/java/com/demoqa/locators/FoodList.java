package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FoodList {
    @Test
    void FindFoodList() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/garnirygpt/lesnoy");


        List<WebElement> hlebIzPekarni = driver.findElements(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a"));
        for (WebElement hleb : hlebIzPekarni) {
            System.out.println(hleb.getText());

            System.out.println(hlebIzPekarni.size());

            List<WebElement> vypechka = driver.findElements(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[1]/div[2]/ul/li[2]/a"));
            for (WebElement bulochki : vypechka) {
                System.out.println(bulochki.getText());

                System.out.println(vypechka.size());


            }
        }
    }
}