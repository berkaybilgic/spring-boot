package com.activityistanbul.gezidb.dataAcces;

import com.activityistanbul.gezidb.entites.Muzeler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuzelerDao extends JpaRepository<Muzeler, Integer> {
}
