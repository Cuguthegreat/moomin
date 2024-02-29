package com.example.moomin.repository;

import com.example.moomin.models.Moomin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoominRepository extends JpaRepository<Moomin, Integer> {

}
