package com.chainsys.reservemeapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.SeatStatusDAO;
import com.chainsys.reservemeapp.dao.impl.SeatStatusImpl;
import com.chainsys.reservemeapp.exception.DbException;

@Service
public class SeatStatusService {
	SeatStatusDAO obj = new SeatStatusImpl();

	public void updatingSeats(int trainNum) throws DbException {
		obj.updatingSeats(trainNum);
	}

	public int AvailSeats(int trainNum) throws DbException {
		return obj.availableSeats(trainNum);
	}

}
