import spi.UserDao;


public class Main {

    private static final UserDao<User, Integer> USER_DAOJPAIMPL = new UserDaoJpaImpl();

    public static void main(String[] args) {

        UserDaoJpaImpl userDaoJpaImpl = new UserDaoJpaImpl();
        userDaoJpaImpl.save(new User());


    }


}
