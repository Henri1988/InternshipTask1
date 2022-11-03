import config.PersistenceJPAConfig;
import entity.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spi.UserDao;

import java.time.LocalDate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class UserTest {

    private UserDao userDao;

    @Test
    public void whenPersist_thenNoExceptionIsThrown() {
        User user = new User( "henri.eessalu@gmail.com", "Henri", "Eessalu",
                "+37256640162", "Urban Architecture AS", "CEO", 3,
                "upkeep123");
        userDao.save(user);
    }


}
