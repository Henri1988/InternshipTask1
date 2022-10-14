import spi.UserDao;

public class Main {

    private static final UserDao<User, Integer> userDaoJpaImpl = new UserDaoJpaImpl();

    public static void main(String[] args) {


        //SAVE
        User user1 = new User("henri.eessalu@gmail.com", "Henri","Eessalu","+37256640162",
                "Urban Architecture As", "CEO", 3, "Upkeep123");
        save(user1);

        //GET
        get();

        //UPDATE
        update(user1);

        //Delete
        delete(user1);

    }

    public static void save(User user) {
        userDaoJpaImpl.save(user);
    }
    public static void update(User user){
        userDaoJpaImpl.update(user);
    }
    public static void delete(User user){
        userDaoJpaImpl.delete(user);
    }
    public static void get(){
        userDaoJpaImpl.find();
    }

}
