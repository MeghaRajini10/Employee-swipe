package com.example.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.TempSwipeData;

@Repository
public interface TempSwipeDataRepository extends JpaRepository<TempSwipeData, Integer> {

	Optional<TempSwipeData> findByempid(int empid);

}
