package com.example.sudheep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import com.example.sudheep.entity.product;

public interface ProductRepository extends PagingAndSortingRepository<product, Integer> 
{
	List<product> findByName(String name);
	List<product> findByDesc(String desc);
	
}
