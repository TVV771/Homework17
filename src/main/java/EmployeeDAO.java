import java.util.List;

public interface EmployeeDAO {
    void createEmloyee();

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    void updateEmployee(int id);

    void deleteEmployee(int id);
}