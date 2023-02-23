package com.example.employee.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.SwipeData;

@Repository
public interface SwipeDataRepository extends JpaRepository<SwipeData, Integer> {


	SwipeData findByemail(String email);

	boolean existsByEmail(String email);

	Collection<? extends SwipeData> findAllByDateBetween(LocalDate from, LocalDate to);

}
