package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.demo.models.Restauranttable;


public interface TableService {
	
	public Iterable<Restauranttable> findAll();
	public Restauranttable find(int id);
	public Restauranttable save(Restauranttable Restauranttable);
	public Restauranttable edit(Restauranttable Restauranttable);
	public boolean delete(int id);
	
	public List<Restauranttable> condition1(boolean status);
	public List<Restauranttable> condition2(double min,double max);
	public List<Restauranttable> condition3( Date start, Date end);
	public List<Restauranttable> like(String keyword );
}
