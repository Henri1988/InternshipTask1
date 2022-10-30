import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import spi.UserDao;

@Configuration
public class AppConfig {
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE");
        return factory;
    }

    @Bean
    public UserDaoJpaImpl userDaoBean() {
        return null;
//        return  new UserDaoJpaImpl();
    }
}
