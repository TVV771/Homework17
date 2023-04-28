import java.util.List;


public interface EmployeeDAO {
    void createEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    void updateEmployee(Employee employee,int id);

    void deleteEmployee(int id);




}