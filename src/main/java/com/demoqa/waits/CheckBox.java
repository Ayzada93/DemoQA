package com.demoqa.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBox {
   private WebDriver driver;

   @BeforeMethod
   void setUp() {
      // Установка пути к драйверу и инициализация WebDriver
      System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
      driver = new ChromeDriver();

      // Установка неявного ожидания
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.manage().window().maximize();
   }


   @Test
   void testDesktop() {
      // Переход на страницу с чекбоксами
      driver.get("https://demoqa.com/checkbox");

      driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
      driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[2]")).click();
      driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[2]")).click();
      WebElement DesktopTest = driver.findElement(By.xpath("//div[@id='result']"));
      String value = DesktopTest.getText();
      String expected = "You have selected :\n" +
              "desktop\n" +
              "notes\n" +
              "commands";
      Assert.assertEquals(value, expected);
   }
      @Test
      void testDocument() {
         driver.get("https://demoqa.com/checkbox");
         driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
         driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[3]")).click();
         driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[3]")).click();
         WebElement DocumentTest = driver.findElement(By.xpath("//div[@id='result']"));
         String value1 = DocumentTest.getText();
         String expected1 = "You have selected :\n" +
                 "documents\n" +
                 "workspace\n" +
                 "react\n" +
                 "angular\n" +
                 "veu\n" +
                 "office\n" +
                 "public\n" +
                 "private\n" +
                 "classified\n" +
                 "general";
         Assert.assertEquals(value1, expected1);
      }
   @Test
   void testDownload() {
      driver.get("https://demoqa.com/checkbox");
      driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
      driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[4]")).click();
      driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[4]")).click();
      WebElement DownloadsTest = driver.findElement(By.xpath("//div[@id='result']"));
      String value2 = DownloadsTest.getText();
      String expected2 = "You have selected :\n" +
              "downloads\n" +
              "wordFile\n" +
              "excelFile";
      Assert.assertEquals(value2, expected2);
   }
   @Test
   void testHome() {
      driver.get("https://demoqa.com/checkbox");

        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[1]")).click();
        WebElement HomeTest = driver.findElement(By.xpath("//div[@id='result']"));
        String value3 = HomeTest.getText();
        String expected3 = "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        Assert.assertEquals(value3, expected3);

    }
}