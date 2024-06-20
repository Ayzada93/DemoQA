package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/label/span[1]/svg")
    public WebElement homeElement;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[1]/svg/path")
    public WebElement desktopElement;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]/svg/path")
    public WebElement notesElement;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]/svg/path")
    public WebElement commandsElement;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[1]/svg")
    public WebElement documentsElement;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/label/span[1]/svg/path")
    public WebElement workSpaceElement;

    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/ol/li[1]/span/label/span[1]")
    public WebElement reactElement;


    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[1]")
    public WebElement angularElement;

    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/ol/li[3]/span/label/span[1]")
    public WebElement veuElement;


    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/label/span[1]/svg")
    public WebElement officeElement;

    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/ol/li[1]/span/label/span[1]")
    public WebElement publicElement;

    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/ol/li[2]/span/label/span[1]")
    public WebElement privateElement;

    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/span/label/span[1]")
    public WebElement classifiedElement;

    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[1]")
    public WebElement generalElement;


    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[1]/svg")
    public WebElement downloadsElement;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[1]/span/label/span[1]/svg")
    public WebElement wordFileElement;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]/svg")
    public WebElement excelFileElement;

    @FindBy(xpath = "//*[@id='tree-node']/ol/li/span/label/span[1]")
    public WebElement homeElementBack;


    public CheckBoxPage clickHomeElement() {
        webElementActions.click(homeElement);
        return this;
    }

    public CheckBoxPage clickDesktopElement() {
        webElementActions.click(desktopElement);
        return this;
    }

    public CheckBoxPage clickNotesElement() {
        webElementActions.click(notesElement);
        return this;

    }

    public CheckBoxPage clickCommandsElement() {
        webElementActions.click(commandsElement);
        return this;
    }

    public CheckBoxPage clickDocumentsElement() {
        webElementActions.click(documentsElement);
        return this;
    }

    public CheckBoxPage clickWorkSpaceElement() {
        webElementActions.click(workSpaceElement);
        return this;
    }

    public CheckBoxPage clickReactElement() {
        webElementActions.click(reactElement);
        return this;

    }

    public CheckBoxPage clickAngularElement() {
        webElementActions.click(angularElement);
        return this;
    }

    public CheckBoxPage clickVeuElement() {
        webElementActions.click(veuElement);
        return this;
    }

    public CheckBoxPage clickOfficeElement() {
        webElementActions.click(officeElement);
        return this;
    }

    public CheckBoxPage clickPublicElement() {
        webElementActions.click(publicElement);
        return this;
    }

    public CheckBoxPage clickPrivateElement() {
        webElementActions.click(privateElement);
        return this;
    }

    public CheckBoxPage clickclassifiedElement() {
        webElementActions.click(classifiedElement);
        return this;
    }

    public CheckBoxPage clickGeneralElement() {
        webElementActions.click(generalElement);
        return this;
    }

    public CheckBoxPage clickDownloadsElement() {
        webElementActions.click(downloadsElement);
        return this;
    }

    public CheckBoxPage clickWordFileElement() {
        webElementActions.click(wordFileElement);
        return this;
    }

    public CheckBoxPage clickExcelFileElement() {
        webElementActions.click(excelFileElement);
        return this;
    }

    public CheckBoxPage clickHomeElementBack() {
        webElementActions.click(homeElementBack);
        return this;
    }
}
