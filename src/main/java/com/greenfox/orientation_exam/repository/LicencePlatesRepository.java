package com.greenfox.orientation_exam.repository;

import com.greenfox.orientation_exam.model.LicencePlates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicencePlatesRepository extends CrudRepository<LicencePlates, Integer>{

    @Query(value = "SELECT * FROM licence_plates;", nativeQuery = true)
    Iterable<LicencePlates> getDatabase();
}
