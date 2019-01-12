package com.example.smit.repository;

import com.example.smit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String  userName);
    Boolean existsByUserName(String username);
    Boolean existsByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    Set<User> getUser();

}
