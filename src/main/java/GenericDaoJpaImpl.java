import org.springframework.stereotype.Component;
import spi.IGenericDao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

//Provides generic common implementation of GenericDao interface persistence methods.
//Extend this abstract class to implement DAO for your specific needs.

@ Component
public abstract class GenericDaoJpaImpl<T, ID extends Serializable> implements IGenericDao<T, ID> {

    private Class<T>persistentClass;
    private EntityManager entityManager;
    public GenericDaoJpaImpl (Class <T>persistentClass){
        this.persistentClass = persistentClass;

    }

    protected EntityManager getEntityManager() {            //We don't want to give access to EM except the classes that extend the GenericDaoJpaImpl
        return entityManager;                               //That's why it is protected.
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {     //This should be public because its annotated.
        this.entityManager = entityManager;                         //When application starts, we need to point where to inject the EntityManager
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }


    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }



}

