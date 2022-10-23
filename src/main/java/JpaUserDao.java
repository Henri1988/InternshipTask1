import jdk.javadoc.internal.doclets.toolkit.util.Group;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spi.User;
import spi.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class JpaUserDao extends GenericDaoJpaImpl<User> implements UserDao {


    static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(Main.class);
    static EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
    static EntityManager em = emf.createEntityManager();


    public JpaUserDao(Class<User> persistentClass) {
        super(persistentClass);
    }





    public User save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
