package com.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Booking;
import com.demo.models.Restauranttable;
import com.demo.models.Tabletype;
import com.demo.repositories.BookingRepository;
import com.demo.repositories.TableRepository;
import com.demo.repositories.TableTypeRepository;

@Service
public class BookingImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> GetAll() {
		List<Booking>bookings = bookingRepository.GetAll();
		return bookings;
	}

	@Override
	public Booking save(Booking booking) {
		bookingRepository.save(booking);
		return booking;
	}

//	@Override
//	public List<Booking> GetAllByUserId(int id) {
//		
//		return bookingRepository.GetAllByUserId(id);
//	}

	

}
