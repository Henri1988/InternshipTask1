package spi;



public interface IGenericDao <k,e> { //k- is the type to use as the key
                                    // e- parameter, is the type of the entity
    void save(e entity);
    void update(e entity);
    void delete(e entity);
    void find();
}
