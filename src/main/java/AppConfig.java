import entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {


    @Bean
    public JpaUserDao userDaoBean (){
        return new JpaUserDao(userDaoBean().getPersistentClass());
    }


}
