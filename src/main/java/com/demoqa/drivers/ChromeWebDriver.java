package com.demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.demoqa.utils.ConfigReader.getValue;

public class ChromeWebDriver {
public static WebDriver loadChromeDriver()  {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    ChromeOptions browserOptions = new ChromeOptions();
    browserOptions.setPlatformName("Windows 11");
    browserOptions.setBrowserVersion("latest");
    Map<String, Object> sauceOptions = new HashMap<>();
    sauceOptions.put("username", "oauth-geniusautomation-178d9");
    sauceOptions.put("accessKey", "***2389");
    sauceOptions.put("build", "<your build id>");
    sauceOptions.put("name", "<your test name>");
    browserOptions.setCapability("sauce:options", sauceOptions);

    URL url = null;
    try {
        url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    }
    RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);



//    options.addArguments("--remote-allow-origins=*");
//    options.addArguments("--disable-extensions");
//    options.addArguments("--window-size-1920,1880");
//    options.addArguments("--no-sandbox");
//options.setPageLoadStrategy(PageLoadStrategy.NONE);
    if (Boolean.parseBoolean(getValue("headless"))){
        browserOptions.addArguments("--headless");
    }

   System.setProperty("webdriver.chrome.driver", "C:\\Ayzada\\DemoQaWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
 driver.manage().deleteAllCookies();
    return  driver;
}


    }
