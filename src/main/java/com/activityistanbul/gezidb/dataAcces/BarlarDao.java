package com.activityistanbul.gezidb.dataAcces;

import com.activityistanbul.gezidb.entites.Barlar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarlarDao extends JpaRepository<Barlar,Integer> {
}
