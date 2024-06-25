import org.testng.annotations.Test;


public class PracticeFormTest extends BaseTest {
    @Test
    public void test123() throws InterruptedException {

        
        browserHelper.open("https://demoqa.com/automation-practice-form");
        demoQaPages.getPracticeFormPage().selectDateMonthYear("30 Jun 2020");
        Thread.sleep(4000);
    }

}
