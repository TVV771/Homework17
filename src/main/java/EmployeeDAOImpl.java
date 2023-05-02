import javax.persistence.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    final String user = "postgres";
    final String password = "0414";
    final String url = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    public List<Employee> getAllEmployee() {
        EntityManager entityManager = createEntityManager();
        Query query= entityManager.createNativeQuery("SELECT *FROM  employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public void mergeOneEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(employee);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void updateOneEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        entityManager.merge(employee);

        transaction.commit();
        entityManager.close();
    }
    @Override
    public void deleteOneEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(employee);
        transaction.commit();
        entityManager.close();
    }

    @Override
        public void selectEmployee(Employee employee, int a) {
            EntityManager entityManager = createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            employee = entityManager.find(Employee.class, a);
            transaction.commit();
            entityManager.close();
        }


        static EntityManager createEntityManager() {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            return entityManagerFactory.createEntityManager();
        }

    }