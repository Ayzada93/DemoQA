import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

        public class DatePickerExample {
            public static void main(String[] args) {
                // Установите путь к драйверу Chrome
                System.setProperty("webdriver.chrome.driver", "/Users/[путь]/Documents/DemoQAWinter24/src/main/resources/drivers/chromedriver");

                WebDriver driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();

                // Откройте страницу с DatePicker
                driver.get("https://demoqa.com/automation-practice-form");

                // Шаг 1: Откройте DatePicker
                WebElement datePicker = driver.findElement(By.id("dateOfBirth-wrapper")); // замените ID_календаря на реальный ID элемента
                datePicker.click();

                // Шаг 2: Выберите месяц и год, если необходимо
                selectDate(driver,  "June",  "2024", "15");

                // Закройте браузер
                driver.quit();
            }

            public static void selectDate(WebDriver driver, String month, String year, String day) {
                // Откройте выпадающий список года и выберите нужный год
                WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
                yearDropdown.click();
                WebElement yearOption = driver.findElement(By.xpath("//option[@value='" + year + "']"));
                yearOption.click();

                // Откройте выпадающий список месяца и выберите нужный месяц
                WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
                monthDropdown.click();
                WebElement monthOption = driver.findElement(By.xpath("//option[text()='" + month + "']"));
                monthOption.click();

                // Выберите день
                WebElement dayElement = driver.findElement(By.xpath("//div[@class, 'react-datepicker__day--0" + day + "']"));
                dayElement.click();
            }
        }