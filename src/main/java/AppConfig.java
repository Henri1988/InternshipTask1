import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


@Configuration
public class AppConfig {
//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
//        factory.setPersistenceUnitName("PERSISTENCE");
//        return factory;
//    }

    @Bean
    public UserDaoJpaImpl userDaoBean() {
        return new UserDaoJpaImpl();
    }
}
