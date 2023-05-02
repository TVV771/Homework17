import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public interface EmployeeDAO {

    List<Employee> getAllEmployee();


    void mergeOneEmployee(Employee employee);
    void updateOneEmployee(Employee employee);
    void deleteOneEmployee(Employee employee);



    void selectEmployee(Employee employee, int a);
}