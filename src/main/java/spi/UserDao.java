package spi;

import java.util.Collection;

public interface UserDao<T,I>{

    void save(T t);
    void update(T t);
    void delete(T t);

    void find(int id);
}
