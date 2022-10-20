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
    private static final IGenericDao<Integer,Group> groupGenericDaoJpaImpl = new GenericDaoJpaImpl();


    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE");
        return factory;
    }

    public static void main(String[] args) {

        Group group1 = new Group("Group 1");
        //SAVE
        saveGroup(group1);

    }

    public static void saveGroup(Group group) {
        groupGenericDaoJpaImpl.save(group);
    }


}