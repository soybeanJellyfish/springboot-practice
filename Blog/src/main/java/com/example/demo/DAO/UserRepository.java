package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

        @Query(value="SELECT * from user u where u.username = ?1", nativeQuery = true)
        User findByUsername(String username);
}
