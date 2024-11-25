package com.nhoclahola.bt_2511_springsecurityjwt_jwt.repositories;

import com.nhoclahola.bt_2511_springsecurityjwt_jwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
}
