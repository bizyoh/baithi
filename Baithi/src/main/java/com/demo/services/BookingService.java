package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.demo.models.Booking;
import com.demo.models.Restauranttable;
import com.demo.models.Tabletype;


public interface BookingService {
	

	public List<Booking> GetAll();
	public Booking save(Booking booking);
//	public List<Booking> GetAllByUserId(int id);
}
