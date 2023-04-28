import java.sql.*;


public class Application {
    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        Employee employee1 = new Employee("Артур", "Арарат", "муж", 70, 4);
        Employee employee2 = new Employee("Михаил", "Скоробогатый", "муж", 20, 3);

        employeeDAO.getAllEmployee();

        employeeDAO.createEmployee(employee1);

        employeeDAO.getEmployeeById(3);

        employeeDAO.updateEmployee(employee2, 7);

        employeeDAO.deleteEmployee(3);
    }


}
