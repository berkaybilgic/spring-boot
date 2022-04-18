package com.activityistanbul.gezidb.dataAcces;

import com.activityistanbul.gezidb.entites.Mekanlar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MekanlarDao extends JpaRepository<Mekanlar, Integer> {

    @Query("SELECT m FROM Mekanlar m WHERE m.mekanKategori='bar'")
    Page<Mekanlar> findAllX(Pageable pageable);


    @Modifying
    @Query("update Mekanlar u set u.mekanName = ?1, u.mekanLocation = ?2 , u.mekanImg = ?3 , u.mekanDescription = ?4 , u.mekanKategori = ?5 " +
            "where u.mekanId = ?6")
    void setUpdateMekanById(Mekanlar mekanlar, int id);

}
