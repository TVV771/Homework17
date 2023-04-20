import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Задаем параметры для подключения к базе данных:
        // имя пользователя, пароль и URL
        final String user = "postgres";
        final String password = "0414";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        // Создаем соединение с базой данных внутри try-with-resources,
        // чтобы автоматически закрыть его после использования
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             // Создаем объект PreparedStatement с SQL-запросом
             // для выборки всех записей из таблицы employee
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee")) {

            // Выполняем SQL-запрос
            // и получаем результаты в виде объекта ResultSet
            ResultSet resultSet = statement.executeQuery();

            // Обрабатываем результаты запроса, перебирая все записи в таблице
            while (resultSet.next()) {
                // Получаем значения полей записи и выводим их на экран
                int idOfEmployee = resultSet.getInt("id");
                System.out.println("id человека: " + idOfEmployee);

                String first_nameOFEmployee = resultSet.getString("first_name");
                String last_nameOFEmployee = resultSet.getString("last_name");
                String genderOFEmployee = resultSet.getString("gender");
                int ageOFEmployee = resultSet.getInt("age");

                System.out.println("Фамилия: " + first_nameOFEmployee);
                System.out.println("Имя: " + last_nameOFEmployee);
                System.out.println("Пол: " + genderOFEmployee);
                System.out.println("Лет: " + ageOFEmployee);
            }

        } catch (SQLException e) {
            // В случае возникновения ошибки при работе с базой данных
            // выводим сообщение об ошибке и информацию об исключении
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }




}

