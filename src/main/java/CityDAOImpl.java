import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CityDAOImpl implements CityDAO{
    final String user = "postgres";
    final String password = "0414";
    final String url = "jdbc:postgresql://localhost:5432/postgres";
    @Override
    public void mergeOneEmployee(City city) {

        EntityManager entityManager = EmployeeDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(city);

        transaction.commit();
        entityManager.close();
    }


    @Override
    public void updateOneEmployee(City city) {

        EntityManager entityManager = EmployeeDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(city);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteOneEmployee(City city) {
        EntityManager entityManager = EmployeeDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(city);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void selectEmployee(City city, int a) {

        EntityManager entityManager = EmployeeDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        city = entityManager.find(City.class, a);

        transaction.commit();
        entityManager.close();
    }

}
