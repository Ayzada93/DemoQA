package alerts_tests;

import com.demoqa.entities.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends BaseTest {

    @Test(description = "Добавление нового сотрудника")
    public void addNewEmployeeTest() {
        // Переходим на страницу с веб-таблицей
        driver.get("https://demoqa.com/webtables");

        // Создаем нового сотрудника
        Employee newEmployee = new Employee("John", "Doe", 30, "john.doe@example.com", 50000, "IT");

        // Добавляем нового сотрудника
        demoQaPages.getWebTablePage().addNewEmployee(newEmployee);

        // Получаем список сотрудников и проверяем, что новый сотрудник добавлен
        List<Employee> employees = demoQaPages.getWebTablePage().getEmployeesFromTable();
        Assert.assertTrue(isEmployeeInList(employees, newEmployee), "New employee not found in the table.");
    }

    @Test(description = "Редактирование данных сотрудника")
    public void editEmployeeTest() {
        // Переходим на страницу с веб-таблицей
        driver.get("https://demoqa.com/webtables");
        // Создаем нового сотрудника
        Employee newEmployee = new Employee("John", "Doe", 30, "john.doe@example.com", 50000, "IT");

        // Добавляем нового сотрудника
        demoQaPages.getWebTablePage().addNewEmployee(newEmployee);

        // Получаем список сотрудников и ищем добавленного сотрудника по email
        List<Employee> employees = demoQaPages.getWebTablePage().getEmployeesFromTable();
        Employee employeeToEdit = getEmployeeByEmail(employees, newEmployee.getEmail());

        // Проверяем, что сотрудник найден
        Assert.assertNotNull(employeeToEdit, "Employee to edit not found in the table.");

        // Создаем новые данные для сотрудника
        Employee editedEmployee = new Employee("EditedJohn", "EditedDoe", 35, "edited.john.doe@example.com", 60000, "Finance");

        // Редактируем данные сотрудника
        demoQaPages.getWebTablePage().editEmployee(newEmployee.getEmail(), editedEmployee);

        // Получаем обновленный список сотрудников
        List<Employee> updatedEmployees = demoQaPages.getWebTablePage().getEmployeesFromTable();

        // Проверяем, что данные сотрудника были обновлены
        Assert.assertTrue(isEmployeeInList(updatedEmployees, editedEmployee), "Edited employee not found in the table.");
    }

    // Вспомогательный метод для проверки наличия сотрудника в списке
    private boolean isEmployeeInList(List<Employee> employees, Employee employee) {
        for (Employee emp : employees) {
            if (emp.getEmail().equals(employee.getEmail())) {
                return true;
            }
        }
        return false;
    }

    // Вспомогательный метод для поиска сотрудника по email
    private Employee getEmployeeByEmail(List<Employee> employees, String email) {
        for (Employee emp : employees) {
            if (emp.getEmail().equals(email)) {
                return emp;
            }
        }
        return null;
    }

    @Test(description = "Delete Employee Test")
    public void deleteEmployeeTest() {
        // Находим существующего сотрудника для удаления
        String emailToDelete = "employee@example.com";

        // Открываем страницу с таблицей
        driver.get("https://demoqa.com/webtables");

        // Удаляем сотрудника
        demoQaPages.getWebTablePage().deleteEmployee(emailToDelete);

        // Проверяем, что сотрудник был удален
        List<Employee> employees = demoQaPages.getWebTablePage().getEmployeesFromTable();
        boolean isEmployeeDeleted = true;
        for (Employee employee : employees) {
            if (employee.getEmail().equals(emailToDelete)) {
                isEmployeeDeleted = false;
                break;
            }
        }
        if (isEmployeeDeleted) {
            System.out.println("Employee with email " + emailToDelete + " was successfully deleted.");
        } else {
            System.out.println("Employee with email " + emailToDelete + " was not deleted.");
        }
    }
}






