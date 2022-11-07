package spi;
import entity.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



public interface UserDao extends IGenericDao<User> {
}

