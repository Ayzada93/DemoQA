package alerts_tests;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ProgressBarTest extends BaseTest {
    @Test(description = "")
    public  void progressBarTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/progress-bar");

    demoQaPages.getProgressBarPage().startProgressBar();
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        wait.until(driver -> {
            int value=Integer.parseInt(demoQaPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"));


        System.out.println("Current progress:"+value+"%");
        if (value>=52){
            return  true;
        }
        return  false;
                });

    demoQaPages.getProgressBarPage().startStopButton.click();
    int progressBarValue=demoQaPages.getProgressBarPage().getProgressBarValue();
        assertEquals(progressBarValue,52,"Progress bar should be at 52%");
    }

}
