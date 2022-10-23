package spi;


import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


//Generic interface for Data Access Objects. To be extended or implemented.
//This interface contains common persistence methods.
@Component
public interface IGenericDao <T> { // T- We allow it to accept any entity types

    T save(T entity);
    T update(T entity);
    void delete(T entity);
    List <T> findAll();
}
