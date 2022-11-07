package dao.impl.classes;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spi.IGenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//Provides generic common implementation of GenericDao interface persistence methods.
//Extend this abstract class to implement DAO for your specific needs.

@Component
@Transactional
public abstract class GenericDaoJpaImpl<T> implements IGenericDao<T> {

    @PersistenceContext
    private Class<T>persistentClass;
    @PersistenceContext
    @Autowired
    private EntityManager entityManager;
    public GenericDaoJpaImpl (Class <T>persistentClass){
        this.persistentClass = persistentClass;

    }

    protected EntityManager getEntityManager() {            //We don't want to give access to EM except the classes that extend the dao.GenericDaoJpaImpl
        return entityManager;                               //That's why it is protected.
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {     //This should be public because its annotated.
        this.entityManager = entityManager;                         //When application starts, we need to point where to inject the EntityManager
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }


    @Override
    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }
    @Override
    public T update(T entity) {
        return entity;
    }
    public void find(){
    }

    @Override
    public void delete(T entity) {
    }


}

