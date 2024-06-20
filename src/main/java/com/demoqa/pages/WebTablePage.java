package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebTablePage extends BasePage {
    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstnameInput;

    @FindBy(id = "lastName")
    public WebElement lastnameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;


    public WebTablePage addNewEmployee(Employee employee) {
        // Находим все строки таблицы
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable.rt-tr-group"));

        // Проверяем, есть ли уже сотрудник с таким email
        for (WebElement row : rows) {
            String email = row.findElement(By.cssSelector(".rt-td:nth-child(4)")).getText();
            if (email.equals(employee.getEmail())) {
                // Если нашли совпадение по email, выводим сообщение и прерываем выполнение метода
                System.out.println("Employee with email " + employee.getEmail() + " already exists.");
                return this;
            }
        }

            // Если сотрудник с таким email не найден, добавляем нового сотрудника
            webElementActions.click(addNewBtn)
                    .sendKeys(firstnameInput, employee.getFirstName())
                    .sendKeys(lastnameInput, employee.getLastName())
                    .sendKeys(ageInput, String.valueOf(employee.getAge()))
                    .sendKeys(emailInput, employee.getEmail())
                    .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                    .sendKeys(departmentInput, employee.getDepartment())
                    .click(submitBtn);
            return this;
        }

        public ArrayList<Employee> getEmployeesFromTable () {
            List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable.rt-tr-group"));


            ArrayList<Employee> employees = new ArrayList<>();
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
                String firstName = cells.get(0).getText();
                String lastName = cells.get(1).getText();
                String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
                String email = cells.get(3).getText();
                String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
                String department = cells.get(5).getText();

                if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                    continue;

                }
                int age = Integer.parseInt(ageText.trim());
                long salary = Long.parseLong(salaryText.trim());
                employees.add(new Employee(firstName, lastName, age, email, salary, department));
            }
            return employees;

        }


public WebTablePage editEmployee(String emailToEdit, Employee newEmployeeData) {
    // Находим все строки таблицы
    List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable.rt-tr-group"));

    // Поиск сотрудника по email и редактирование его данных
    for (WebElement row : rows) {
        String email = row.findElement(By.cssSelector(".rt-td:nth-child(4)")).getText();
        if (email.equals(emailToEdit)) {
            // Найден сотрудник, теперь заполняем поля новыми данными и сохраняем изменения
            WebElement editButton = row.findElement(By.cssSelector(".rt-td:nth-child(7) .edit"));

            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            WebElement clickableEditButton = wait.until(ExpectedConditions.elementToBeClickable(editButton));
            clickableEditButton.click();


            // Заполнение полей новыми данными
            WebElement editFirstnameInput = DriverManager.getDriver().findElement(By.id("firstName"));
            WebElement editLastnameInput = DriverManager.getDriver().findElement(By.id("lastName"));
            WebElement editAgeInput = DriverManager.getDriver().findElement(By.id("age"));
            WebElement editEmailInput = DriverManager.getDriver().findElement(By.id("userEmail"));
            WebElement editSalaryInput = DriverManager.getDriver().findElement(By.id("salary"));
            WebElement editDepartmentInput = DriverManager.getDriver().findElement(By.id("department"));

            webElementActions.clearAndSendKeys(editFirstnameInput, newEmployeeData.getFirstName());
            webElementActions.clearAndSendKeys(editLastnameInput, newEmployeeData.getLastName());
            webElementActions.clearAndSendKeys(editAgeInput, String.valueOf(newEmployeeData.getAge()));
            webElementActions.clearAndSendKeys(editEmailInput, newEmployeeData.getEmail());
            webElementActions.clearAndSendKeys(editSalaryInput, String.valueOf(newEmployeeData.getSalary()));
            webElementActions.clearAndSendKeys(editDepartmentInput, newEmployeeData.getDepartment());

            // Нажимаем кнопку сохранения изменений
            WebElement saveButton = DriverManager.getDriver().findElement(By.id("submit"));
            webElementActions.click(saveButton);
            return this;
        }
    }

    // Если сотрудник с указанным email не найден, выводим сообщение об ошибке
    System.out.println("Employee with email " + emailToEdit + " not found.");
    return this;
}
    public WebTablePage deleteEmployee(String emailToDelete) {
        // Находим все строки таблицы
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable.rt-tr-group"));

        // Поиск сотрудника по email и удаление его
        for (WebElement row : rows) {
            String email = row.findElement(By.cssSelector(".rt-td:nth-child(4)")).getText();
            if (email.equals(emailToDelete)) {
                // Найден сотрудник, теперь удаляем его
                WebElement deleteButton = row.findElement(By.cssSelector(".rt-td:nth-child(7) .delete"));
                deleteButton.click();

                // Добавляем ожидание подтверждения удаления, например, появление модального окна
                WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
                WebElement confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteConfirmationButton")));
                confirmDeleteButton.click();
                return this;
            }
        }

        // Если сотрудник с указанным email не найден, выводим сообщение об ошибке
        System.out.println("Employee with email " + emailToDelete + " not found.");
        return this;
    }

}