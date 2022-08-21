package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.models.Restauranttable;
import com.demo.models.Tabletype;

@Repository
public interface TableTypeRepository extends CrudRepository<Tabletype, Integer> 
{
	
//	@Query("select t FROM Tabletype t where t.id :=id")
//	 Tabletype GetTableTypeById(@Param("id") int id );
//	@Query("from Tabletype where name = :name")
//	public Account findByUsername(@Param("name") String name);
	
	@Query("FROM Tabletype where id =:id")
	 Tabletype GetTableTypeById(@Param("id") int id );
}