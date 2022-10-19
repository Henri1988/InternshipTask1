package spi;



public interface GroupDao <T,I> {
    void save(T t);
    void update(T t);
    void delete(T t);

    void find();
}
