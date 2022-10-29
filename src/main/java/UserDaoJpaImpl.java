import spi.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UserDaoJpaImpl implements UserDao<User, Integer> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
    private EntityManager entityManager;
    public UserDaoJpaImpl() {
        entityManager = emf.createEntityManager();
    }


    @Override
    public void save(User user) {
        System.out.println("Creating user ...");
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

    }

    @Override
    public void update(User user) {
        System.out.println("Updating user ...");
        entityManager.getTransaction().begin();
        user = entityManager.find(User.class, 92);

        user.setFirstName("Rob");
        user.setLastName("Ryan");
        user.setEmail("rob.ryan@mail.com");
        user.setCompanyName("Kuehne & Nagel");
        user.setMobileNumber("+37287253823");
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(User user) {
        System.out.println("Deleting user ...");
        entityManager.getTransaction().begin();

        user = entityManager.find(User.class, 92);
        System.out.println("user id :: " + user.getId());
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void find() {
        System.out.println("Finding user ...");
        User user = entityManager.find(User.class, 91);

        if(user !=null){
            System.out.println(user.toString());
        }
    }

    public void close() {
        emf.close();
    }


}
