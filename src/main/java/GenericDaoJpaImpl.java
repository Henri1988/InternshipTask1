import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spi.IGenericDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@Component
public class GenericDaoJpaImpl implements IGenericDao <User, Integer> {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(Main.class);
    EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
    EntityManager em = emf.createEntityManager();


    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void find() {

    }
}
