package com.example.demo.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserroleRespository extends JpaRepository<Userrole, Integer> {

    @Query(value="SELECT * FROM userrole u where u.user_id = ?1", nativeQuery = true)
    List<Userrole> findByUserId(int userId);
}
