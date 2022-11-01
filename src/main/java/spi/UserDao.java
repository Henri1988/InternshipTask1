package spi;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;



@Component
public interface UserDao<T,I>{

    void save(T t);
    void find(int userId);
    void update(T t);
    void delete(T t);
    void close();
}
