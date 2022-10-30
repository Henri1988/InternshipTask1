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
        try {
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            System.out.println("Created user " + user);
        } catch (Exception ex){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(User user) {
        System.out.println("Updating user ...");
        entityManager.getTransaction().begin();

        user.setFirstName("Rob");
        user.setLastName("Ryan");
        user.setEmail("rob.ryan@mail.com");
        user.setCompanyName("Kuehne & Nagel");
        user.setMobileNumber("+37287253823");
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        User updatedUser = entityManager.find(User.class, user.getId());
        System.out.println("Updated user: "+ updatedUser);
    }

    @Override
    public void delete(User user) {
        System.out.println("Deleting user ...");
        entityManager.getTransaction().begin();

        System.out.println("user id :: " + user.getId());
        entityManager.remove(user);
        entityManager.getTransaction().commit();

        User deletedUser = entityManager.find(User.class, user.getId());
        System.out.println("Deleted user " + deletedUser);
    }

    @Override
    public void find(int userId) {
        System.out.println("Finding user ...");
        User user = entityManager.find(User.class, userId );

        if(user !=null){
            System.out.println(user.toString());
        }
    }

    @Override
    public void close() {
        emf.close();
    }
}
