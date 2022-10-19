package spi;



public interface IGenericDao <T,I> {
    void save(T t);
    void update(T t);
    void delete(T t);
    void find();
}
