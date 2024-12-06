package com.nimaptask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimaptask.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
