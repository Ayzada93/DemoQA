package com.demoqa.pages;

import com.demoqa.helper.WebElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class ProgressBarPage extends BasePage{
    @FindBy(id="startStopButton")
    public WebElement startStopButton;

    @FindBy(id="progressBar")
    public WebElement progressBar;

    @FindBy(xpath = "//div[@aria-valuenow]")
    public WebElement aria_valuenow;

    public void startProgressBar(){
        startStopButton.click();

    }
    @Step(" Get progress bar value")
    public int getProgressBarValue(){
        String value=aria_valuenow.getAttribute("aria-valuenow");
        return Integer.parseInt(value);
    }

}
