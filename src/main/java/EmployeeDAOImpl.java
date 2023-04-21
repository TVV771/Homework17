import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    final String user = "postgres";
    final String password = "postgres";
    final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void createEmloyee() {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO employee (first_name, last_name, gender, age, citi_id) VALUES ('Василий', 'Васильев', 'муж', 65, 4)");
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Employee getEmployeeById(int id) {

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM employee FULL JOIN citi ON employee.citi_id = citi.citi_id WHERE id =" + id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int id_employee = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            int citi_id = resultSet.getInt("citi_id");
            String citi_name = resultSet.getString("citi_name");

            return new Employee(id_employee, first_name, last_name, gender, age, citi_id, citi_name);

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee FULL JOIN citi ON employee.citi_id = citi.citi_id")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id_employee = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int citi_id = resultSet.getInt("citi_id");
                String citi_name = resultSet.getString("citi_name");
                employees.add(new Employee(id_employee, first_name, last_name, gender, age, citi_id, citi_name));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(int id) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("UPDATE employee SET last_name = 'Гришин' WHERE id = " + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteEmployee(int id) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id = " + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}