package tech.itmentors.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.itmentors.crud.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findById(long id);

}
