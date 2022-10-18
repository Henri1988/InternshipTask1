import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import spi.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class Main {

    //private static final UserDao<User, Integer> userDaoJpaImpl = new UserDaoJpaImpl();

    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE");
        return factory;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();
        try {
            nativeQuery(em, "SHOW TABLES");
            nativeQuery(em, "SHOW COLUMNS from Person");

        } finally {
            em.close();
            emf.close();
        }
    }

    private static void nativeQuery(EntityManager em, String s) {
        System.out.printf("---------------------------%n'%s'%n", s);
        Query query = em.createNativeQuery(s);
        List list = query.getResultList();
        for (Object o : list) {
            if (o instanceof Object[]) {
                System.out.println(Arrays.toString((Object[]) o));
            } else {
                System.out.println(o);
            }
        }
    }



}
