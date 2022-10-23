import jdk.javadoc.internal.doclets.toolkit.util.Group;
import spi.GroupDao;

import javax.persistence.PersistenceContext;
import java.util.List;


public class JpaGroupDao extends GenericDaoJpaImpl<Group> implements GroupDao {


    public JpaGroupDao(Class<Group> persistentClass) {
        super(persistentClass);
    }

    @PersistenceContext
    @Override
    public Group save(Group entity) {
        return null;
    }

    @Override
    public Group update(Group entity) {
        return null;
    }

    @Override
    public void delete(Group entity) {

    }

    @Override
    public List<Group> findAll() {
        return null;
    }
}
