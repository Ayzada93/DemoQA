package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {
    private WebDriver driver = DriverManager.getDriver();

    public AlertHelper(WebDriver driver) {
        this.driver = driver;

    }

    public Alert getAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10))     //если через определенное время появл Алерт, то устонавливаем Явное ожидание
                .until(ExpectedConditions.alertIsPresent()); //т.е. это значит: Жди до тех пор пока Алерт не появится
        return driver.switchTo().alert();
    }

    public void acceptAlert() {
        getAlert().accept();
    }

    public void dismissAlert() {
        getAlert().dismiss();
    }

    public String getAlertText() {
        return getAlert().getText();

    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void acceptAlertIfPresented() {
        if (isAlertPresent())
            return;
        acceptAlert();
    }

    public void dismissAlertIfPresented() {
        if (!isAlertPresent())
            return;
        dismissAlert();
    }

    public void acceptPrompt(String txt) { //вызываем метод ,передаем какой то текст(txt)
        if (isAlertPresent())            //если Алерта нету
            return;                      // останавливаем на этом этапе
        Alert alert = (getAlert());       // если есть то переходим сюда. Находим Алерт
        alert.sendKeys(txt);             // нажимаем sendkeys
        alert.accept();                  // принимаем условие
    }

    public void dismissPrompt(String txt) {
        if (isAlertPresent())
            return;
        Alert alert = (getAlert());
        alert.sendKeys(txt);
        alert.dismiss();
    }
}