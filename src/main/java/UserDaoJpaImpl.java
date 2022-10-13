import spi.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class UserDaoJpaImpl implements UserDao<User, Integer> {

    public void save(User user) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        user = new User("henri.eessalu@gmail.com", "Henri","Eessalu","+37256640162",
                "Urban Architecture As", "CEO", 3, "Upkeep123");
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
//
//    @Override
//    public Collection<User> getAll() {
//        return null;
//    }
//
//    @Override
//    public void update(User user) {
//    }
//
//    @Override
//    public void delete(User user) {
//    }







}
