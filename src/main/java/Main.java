import jdk.javadoc.internal.doclets.toolkit.util.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import spi.GroupDao;
import spi.IGenericDao;



@Configuration
public class Main {




//  private static final UserDao<User, Integer> userGenericDaoJpaImpl = new GenericDaoJpaImpl();





    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE");
        return factory;
    }

    public static void main(String[] args) {

    }



}