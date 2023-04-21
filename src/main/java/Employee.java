import java.sql.*;

import java.util.List;

public class Employee {
    private int id;
    private String first_Name;
    private String last_Name;
    private String gender;
    private int age;

    public Employee(int id, String first_Name, String last_Name, String gender, int age) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.gender = gender;
        this.age = age;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static void main(String[] args) throws SQLException {
        // Создаем объект EmployeeDao

        EmployeeDao employeeDao = new EmployeeDao();

        // Создаем новый объект Employee и добавляем его в базу данных
        Employee newEmployee = new Employee(1, "Маркевич", "Марина", "gerl", 23);
        employeeDao.addEmployee(newEmployee);

        // Получаем объект Employee из базы данных по его id
        Employee employee = employeeDao.getEmployeeById(1);
        System.out.println("ID человека " + employee.getId() + " поиск: " + employee.getFirst_Name() + " " + employee.getLast_Name() + ", " + employee.getGender() + ", " + employee.getAge());

        // Получаем список всех объектов Employee из базы данных
        List<Employee> employees = employeeDao.getAllEmployees();
        System.out.println("Все люди:");
        for (Employee e : employees) {
            System.out.println(e.getFirst_Name() + " " + e.getLast_Name() + ", " + e.getGender() + ", " + e.getAge());
        }

        // Изменяем объект Employee в базе данных
        Employee updatedEmployee = new Employee(1, "Маркевич", "Марина", "gerl", 23);
        employeeDao.updateEmployee(updatedEmployee);
        employee = employeeDao.getEmployeeById(1);
        System.out.println("ID человека " + employee.getId() + " обновить: " + employee.getFirst_Name() + " " + employee.getLast_Name() + ", " + employee.getGender() + ", " + employee.getAge());

        // Удаляем объект Employee из базы данных
        employeeDao.deleteEmployeeById(1);
        employee = employeeDao.getEmployeeById(1);
        System.out.println("ID человека " + employee.getId() + " удалить");
    }





}
