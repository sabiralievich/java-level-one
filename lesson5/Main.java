package ru.gb.lesson5;

public class Main {
    public static void main(String[] args) {

        createArrayOfEmployees();
        System.out.println("Всего в компании " + Employee.employeeCounter + " сотрудников.");
    }

    private static void createArrayOfEmployees() {
        Employee[] employeeArray = new Employee[5];
        for (int i = 0; i < 5; i++) {
            System.out.println(employeeArray[i] = createFiveEmployees(i));

        }
    }

    private static Employee createFiveEmployees(int number) {

        if (number == 0) {
            return new Employee("Peter", "engineer", "e001@company.com", "+13425642556", 10000.00, 42);
        }
        if (number == 1) {
            return new Employee("John", "tester", "e002@company.com", "+13425642557", 8000.00, 34);
        }
        if (number == 2) {
            return new Employee("Sally", "programmer", "e003@company.com", "+13425642558", 9000.00, 25);
        }
        if (number == 3) {
            return new Employee("Igor Chestnov", "teacher", "e004@company.com", "+13425642559", 11000.00, 35);
        }
        if (number == 4) {
            return new Employee("Timofei Safronov", "teacher", "e005@company.com", "+13425642555", 11000.00, 36);
        }
        return new Employee("New Employee", "position", "email@company.com", "+phone number", 0.00, 0);

    }

}
