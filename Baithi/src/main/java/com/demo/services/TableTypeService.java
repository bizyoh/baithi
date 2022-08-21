package com.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.demo.models.Restauranttable;
import com.demo.models.Tabletype;


public interface TableTypeService {
	

	public Iterable<Tabletype> GetAll();
	public Tabletype Save(Tabletype tabletype);
	public void Delete(int id);
	public Optional<Tabletype> GetById(int id);
	public Tabletype GetTableTypeById(int id);
}
