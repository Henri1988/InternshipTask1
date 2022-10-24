package spi;
import entities.User;
import org.springframework.stereotype.Component;


@Component
public interface UserDao extends IGenericDao<User>{
}

