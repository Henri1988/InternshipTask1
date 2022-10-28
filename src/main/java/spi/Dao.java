package spi;


import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public interface Dao <T,I>{
    Optional<T> get(int id);

    Collection<T> getAll() throws SQLException;

    void save(T t) throws SQLException;
    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;
}
