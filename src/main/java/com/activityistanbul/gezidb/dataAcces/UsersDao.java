package com.activityistanbul.gezidb.dataAcces;

import com.activityistanbul.gezidb.entites.Barlar;
import com.activityistanbul.gezidb.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersDao extends JpaRepository<Users, Integer> {

    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    public Users findByEmail(String email);




}
