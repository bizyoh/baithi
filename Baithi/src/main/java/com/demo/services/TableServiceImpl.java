package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Restauranttable;
import com.demo.repositories.TableRepository;

@Service
public class TableServiceImpl implements TableService {
	
	@Autowired
	private TableRepository TableRepository;

	@Override
	public Iterable<Restauranttable> findAll() {		
		return TableRepository.findAll();
	}

	@Override
	public Restauranttable find(int id) {
		return TableRepository.findById(id).get();
	}

	@Override
	public Restauranttable save(Restauranttable Restauranttable) {
		return TableRepository.save(Restauranttable);
	}

	@Override
	public boolean delete(int id) {
		try {
			TableRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}



	@Override
	public List<Restauranttable> condition2(double min, double max) {
		// TODO Auto-generated method stub
		return TableRepository.condition2(min, max);
	}

	@Override
	public List<Restauranttable> condition3(Date start, Date end) {
		// TODO Auto-generated method stub
		return TableRepository.condition3(start, end);
	}



	@Override
	public List<Restauranttable> like(String keyword) {
		
		return TableRepository.like(keyword);
	}

	@Override
	public List<Restauranttable> condition1(boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restauranttable edit(Restauranttable Restauranttable) {
		return TableRepository.save(Restauranttable);
	}

}
