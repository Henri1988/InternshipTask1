package spi;
import entity.model.User;
import org.springframework.stereotype.Component;


@Component
public interface UserDao extends IGenericDao<User>{
}

