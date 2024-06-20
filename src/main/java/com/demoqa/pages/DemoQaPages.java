package com.demoqa.pages;
import com.demoqa.pages.alerts.AlertPage;
import lombok.*;


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Builder

    public class DemoQaPages {



       public TextBoxPage     textBoxPage = new TextBoxPage();

         public AlertPage alertPage = new AlertPage();

          public ButtonsPage  buttonsPage = new ButtonsPage();
          public MenuPage  menuPage = new MenuPage();
          public  ProgressBarPage progressBarPage = new ProgressBarPage();
          public WebTablePage webTablePage=new WebTablePage();
          public PracticeFormPage practiceFormPage=new PracticeFormPage();

        }