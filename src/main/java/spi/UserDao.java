package spi;


public interface UserDao<T,I>{

//    Collection<T> getAll();
    void save(T t);
//    void update(T t);
//    void delete(T t);
}
