package dao.impl.classes;

import entity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spi.UserDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class JpaUserDao extends GenericDaoJpaImpl<User> implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceContext
    private EntityManagerFactory emf;

    public JpaUserDao(Class<User> persistentClass) {
        super(persistentClass);
    }

    @Override
    public  User save(User user) {
        System.out.println("Adding user...");
        entityManager.getTransaction().begin();

        try {
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            System.out.println("Created user: " + user);
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
        return user;
    }

    @Override
    public User update(User user) {
        System.out.println("Updating user...");
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        User updatedUser = entityManager.find(User.class, user.getUserId());
        System.out.println("Updated user: " + updatedUser);
        return user;
    }

    @Override
    public void find(int userId) {
        System.out.println("Finding user...");
        User user = entityManager.find(User.class, userId);

        if(user != null){
            System.out.println(user.toString());
        }
    }

    @Override
    public void delete(User user){
        System.out.println("Deleting user...");
        entityManager.getTransaction().begin();

        System.out.println("user id :: " + user.getUserId());
        entityManager.remove(user);
        entityManager.getTransaction().commit();

        User deletedUser = entityManager.find(User.class, user.getUserId());
        System.out.println("Deleted user: " + deletedUser);
    }

    @Override
    public void close(){
        emf.close();
    }



}
