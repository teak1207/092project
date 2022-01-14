package com.example.demo.repository;

import com.example.demo.domain.RemindModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemindRepository extends JpaRepository<RemindModel,Long> {
}
