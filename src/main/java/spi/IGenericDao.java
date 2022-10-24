package spi;


import org.springframework.stereotype.Component;



//Generic interface for Data Access Objects. To be extended or implemented.
//This interface contains common persistence methods.
@Component
public interface IGenericDao <T> { // T- We allow it to accept any entity types

    T save(T entity);
    T update(T entity);
    void delete(T entity);
    void find();


}
