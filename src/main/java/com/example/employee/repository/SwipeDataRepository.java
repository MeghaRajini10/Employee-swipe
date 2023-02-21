package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.entity.SwipeData;

public interface SwipeDataRepository extends JpaRepository<SwipeData, Integer> {

}
