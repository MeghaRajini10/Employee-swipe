package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.entity.TempSwipeData;

public interface TempSwipeDataRepository extends JpaRepository<TempSwipeData, Integer> {

}
