import jdk.javadoc.internal.doclets.toolkit.util.Group;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import spi.GroupDao;
import spi.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;



@PersistenceContext
public class JpaGroupDao extends GenericDaoJpaImpl<Group> implements GroupDao {


    static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(Main.class);
    static EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
    static EntityManager em = emf.createEntityManager();

    public JpaGroupDao(Class<Group> persistentClass) {
        super(persistentClass);
    }


    public Group save(Group group) {
        em.getTransaction().begin();
        em.persist(group);
        em.getTransaction().commit();
        return group;
    }







    @Override
    public Group update(Group entity) {
        return null;
    }

    @Override
    public void delete(Group entity) {

    }

    @Override
    public List<Group> findAll() {
        return null;
    }
}
