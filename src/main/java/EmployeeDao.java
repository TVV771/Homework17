import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
     Connection connection;

    public EmployeeDao() {
        this.connection = connection;
    }

    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (id, first_name, last_name, gender, age) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, employee.getId());
        statement.setString(2, employee.getFirst_Name());
        statement.setString(3, employee.getLast_Name());
        statement.setString(4, employee.getGender());
        statement.setInt(5, employee.getAge());
        statement.executeUpdate();
    }

    public Employee getEmployeeById(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFirst_Name(resultSet.getString("first_name"));
            employee.setLast_Name(resultSet.getString("last_name"));
            employee.setGender(resultSet.getString("gender"));
            employee.setAge(resultSet.getInt("age"));
            return employee;
        }
        return null;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFirst_Name(resultSet.getString("first_name"));
            employee.setLast_Name(resultSet.getString("last_name"));
            employee.setGender(resultSet.getString("gender"));
            employee.setAge(resultSet.getInt("city"));
            employees.add(employee);
        }
        return employees;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET first_name=?, last_name=?, gender=?, age=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee.getFirst_Name());
        statement.setString(2, employee.getLast_Name());
        statement.setString(3, employee.getGender());
        statement.setInt(4, employee.getAge());
        statement.setInt(5, employee.getId());
        statement.executeUpdate();
    }

    public void deleteEmployeeById(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();


    }
}