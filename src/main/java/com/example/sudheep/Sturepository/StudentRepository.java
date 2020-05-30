package com.example.sudheep.Sturepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.sudheep.stuentity.Student;

@Component
public interface StudentRepository extends JpaRepository< Student, Integer> 
{
	List<Student> findByFirstname(String firstname);
	
	List<Student> findById(int id);
	
	List<Student> findByIdGreaterThan(int id);
	
	List<Student> findByIdGreaterThanEqual(int id);
	
	List<Student> findByFirstnameLike(String firstname);
	
	List<Student> findByIdIn(List<Integer> id);
	

}
