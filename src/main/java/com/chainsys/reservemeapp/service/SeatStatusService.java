package com.chainsys.reservemeapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.SeatStatusDAO;
import com.chainsys.reservemeapp.dao.impl.SeatStatusIMPL;
import com.chainsys.reservemeapp.exception.DbException;

@Service
public class SeatStatusService {
	SeatStatusDAO obj = new SeatStatusIMPL();

	public void updatingSeats(int trainNum) throws DbException {
		obj.updatingSeats(trainNum);
	}

	public int AvailSeats(int trainNum) throws DbException {
		return obj.AvailSeats(trainNum);
	}

}
