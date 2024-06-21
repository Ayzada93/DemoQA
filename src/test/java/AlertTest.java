import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;



public class AlertTest extends BaseTest {
    @Test(groups={"Smoke", "UI","1721"},description  ="Alert Test")
    @Description("Verify that alert is present")
    @Owner("Ayzada")
    @Tag("Smoke")
    @Severity(SeverityLevel.CRITICAL)
    @Story("GCPINT-8877")
    @Epic("Registration")
    @Link("www.google.com")

    void alertTest() {
        browserHelper.open(ConfigReader.getValue("baseDEVURL") + Endpoints.ALERT.getEndpoint());
        webElementActions.click(demoQaPages.getAlertPage().confirmAlertButton);

        alertHelper.dismissPrompt("Hello world");
        webElementActions.pause(5);


    }
    @Test(groups = {"Regression", "API", "1722"}, description = "Alert Test1")
    void alertTest1() {
                WebDriverManager.chromiumdriver().setup();
          WebDriver driver = new ChromeDriver();
                webElementActions.click(demoQaPages.getAlertPage().confirmAlertButton);
                alertHelper.acceptAlert();
                driver.get("asdas");

            }
    @Test(groups = {"E2E", "SQL", "1723"}, description = "Alert Test2")
    void alertTest2() {
         WebDriverManager.chromiumdriver().setup();
          WebDriver driver = new ChromeDriver();
        webElementActions.click(demoQaPages.getAlertPage().confirmAlertButton);
        alertHelper.acceptAlert();

}
}
