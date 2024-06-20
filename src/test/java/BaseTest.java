package alerts_tests;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.AlertHelper;
import com.demoqa.helper.BrowserHelper;
import com.demoqa.helper.IframeHelper;
import com.demoqa.helper.WebElementActions;
import com.demoqa.pages.*;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    protected RandomUtils randomUtils;
   protected WebElementActions webElementActions;

    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;
   protected  DemoQaPages demoQaPages;
protected IframeHelper iframeHelper;



    @BeforeClass(alwaysRun = true)
    public  void setUp() {
        driver = DriverManager.getDriver();

        randomUtils=new RandomUtils();
webElementActions=new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper=new BrowserHelper(driver);
       demoQaPages=new DemoQaPages();
   iframeHelper=new IframeHelper(driver);
    }
@AfterClass(alwaysRun = true)
        public void tearDown(){
    DriverManager.closeDriver();
        }
    }

