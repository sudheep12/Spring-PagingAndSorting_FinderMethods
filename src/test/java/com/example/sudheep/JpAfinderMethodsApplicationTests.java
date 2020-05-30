package com.example.sudheep;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.example.sudheep.Sturepository.StudentRepository;
import com.example.sudheep.entity.product;
import com.example.sudheep.repository.ProductRepository;
import com.example.sudheep.stuentity.Student;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@SpringBootTest
class JpAfinderMethodsApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired	
	ProductRepository repos;

	@Test
	void findbyName()
	{
		System.out.print("================================================HEREEE");
		List<product> list = repos.findByName("iphone");
		for(product i:list)
		{
			System.out.print("================================================HERE");
			System.out.print(i.getName());
			System.out.print(i.getId());
			System.out.print(i.getDesc());
			System.out.print(i.getPrice());
		}
	}
	@Test
	void findbyDesc()
	{
		System.out.print("================================================HEREEE");
		List<product> list = repos.findByDesc("pro");
		for(product i:list)
		{
			System.out.print("================================================HERE");
			System.out.print(i.getName());
			System.out.print(i.getId());
			System.out.print(i.getDesc());
			System.out.print(i.getPrice());
		}
	}
	
	@Test
	public void paging()
	{ 
		Pageable pageable = PageRequest.of(0, 3,org.springframework.data.domain.Sort.by("price").descending());
		Page<product> page = repos.findAll(pageable);
		System.out.println("*****************************" + page.getSize());
		System.out.println(page);
		page.forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));
	}
	
	@Test
	public void paging2()
	{ 
		Pageable pageable = PageRequest.of(0, 2, org.springframework.data.domain.Sort.by(Direction.DESC,"price"));
		Page<product> page = repos.findAll(pageable);
		page.forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));
	}
	@Test
	public void sortByOneRecord()
	{
		Iterable<product> iterable = repos.findAll(org.springframework.data.domain.Sort.by("price"));
		iterable.forEach(p  -> System.out.println(p.getDesc() + "  " + p.getPrice()));
		
	}
	@Test
	public void sortByOneDirection()
	{
		Iterable<product> iterable = repos.findAll(org.springframework.data.domain.Sort.by(Direction.DESC, "price","name"));
		iterable.forEach(p  -> System.out.println(p.getDesc() + "  " + p.getPrice() + "  " + p.getName()));
	}
	
	@Test
	public void sortByMultipleRecords()
	{
		Iterable<product> iterable = repos.findAll(org.springframework.data.domain.Sort.by("name","price"));
		iterable.forEach(p  -> System.out.println(p.getDesc() + "  " + p.getPrice() + "  " + p.getName()));
	}
	
	@Test
	public void sortByMultiplePropertiesAndDirection()
	{
		Iterable<product> iterable = repos.findAll(org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Order.desc("name"), org.springframework.data.domain.Sort.Order.asc("price")));
		iterable.forEach(p  -> System.out.println(p.getDesc() + "  " + p.getPrice() + "  " + p.getName()));
	}
	
	/* ================================================================================================================================ */
	
	@Autowired
	StudentRepository stuRepos;
	
	@Test
	public void testFindByFirstname()
	{
		long count = stuRepos.count();
		System.out.print(count);
		List<Student> student = stuRepos.findByFirstname("alex");
		student.forEach(s -> System.out.println(s.getLastname()));
	}
	
	@Test
	public void testFindById()
	{
		
		List<Student> student = stuRepos.findById(2);
		student.forEach(s -> System.out.println(s.getLastname()));
	}

	@Test
	public void testGreaterThan()
	{
		
		List<Student> student = stuRepos.findByIdGreaterThan(2);
		List<Student> student2 = stuRepos.findByIdGreaterThanEqual(2);
		student2.forEach(s -> System.out.println(s.getLastname()));
	}
	
	@Test
	public void testLike()
	{
		
		List<Student> student = stuRepos.findByFirstnameLike("%a%");
		student.forEach(s -> System.out.println(s.getLastname()));
	}
	
	@Test
	public void testIn()
	{
		List<Integer> array = new ArrayList<Integer>();
		array.add(2);
		array.add(3);
		array.add(4);
		List<Student> student = stuRepos.findByIdIn(array);
		student.forEach(s -> System.out.println(s.getLastname()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
