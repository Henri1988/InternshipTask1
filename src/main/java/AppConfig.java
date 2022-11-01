import entities.User;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {

    public JpaUserDao userDaoBean (){
        return new JpaUserDao(userDaoBean().getPersistentClass());

    }


}
