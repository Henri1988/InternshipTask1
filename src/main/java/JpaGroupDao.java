
import entities.Group;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spi.GroupDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;



@PersistenceContext
@Component
public class JpaGroupDao extends GenericDaoJpaImpl<Group> implements GroupDao {


    static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(Main.class);
    static EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
    static EntityManager em = emf.createEntityManager();

    public JpaGroupDao(Class<Group> persistentClass) {
        super(persistentClass);
    }


    @Override
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

}
