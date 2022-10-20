import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spi.GroupDao;
import spi.IGenericDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;


@Component
public class GenericDaoJpaImpl<k, e> implements IGenericDao<k, e> {

    private final Class entityBeanType;
    @PersistenceContext
    protected EntityManager em;

    @SuppressWarnings("unchecked")
    public GenericDaoJpaImpl() {
        this.entityBeanType = ((Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public void save(e entity) {

        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println( entity + " cannot be added.");
        }
    }










    @Override
    public void update(e entity) {

    }

    public void delete(e entity) {
        em.remove(entity);
    }

    @Override
    public void find() {

    }

}

