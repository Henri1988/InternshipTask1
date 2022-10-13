import spi.UserDao;

import java.util.Collection;
import java.util.Optional;


public class UserDaoJpaImpl implements UserDao<User, Integer> {

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public Optional<Integer> save(User user) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
