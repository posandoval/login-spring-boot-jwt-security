package com.posandoval.demojwtmysql.User;

import com.posandoval.demojwtmysql.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //Query Method
   Optional<User> findByUsername(String username);
}
