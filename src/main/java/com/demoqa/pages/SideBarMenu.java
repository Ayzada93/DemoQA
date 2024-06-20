package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.pages.alerts.enums.SideBarMenuEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.demoqa.pages.alerts.enums.SideBarMenuEnum.ADMIN;

public class SideBarMenu {
    @FindBy(className = "oxd-topbar-body")
    public WebElement topBarBody;

    @FindBy(className = "oxd-sidepanel-body")
    public  WebElement sideBarMenu;


    public  SideBarMenu chooseSideBarMenu(SideBarMenuEnum sideBarMenuName){
        topBarBody.findElement(By.xpath("//ul/li"));
        WebElement element= DriverManager.getDriver().findElement(By.xpath("//ul[@class='oxd-main-menu']/li/a/span[text()='"+sideBarMenuName.getMenu()+"']"));

return  this;
    }
    public String someTxt(String topBarMenuName,String... value){
        return "sadfas";

    }

    public static void main(String[] args) {
        SideBarMenu sideBarMenu=new SideBarMenu();
        sideBarMenu.chooseSideBarMenu(ADMIN);

        sideBarMenu.someTxt("Ayza");
        sideBarMenu.someTxt("Ayza","SomeValue");
    }
}
