package spi;


import org.springframework.stereotype.Component;

@Component
public interface GroupDao <T,I> extends IGenericDao <T,I> {
    void save(T t);
    void update(T t);
    void delete(T t);

    void find();
}
