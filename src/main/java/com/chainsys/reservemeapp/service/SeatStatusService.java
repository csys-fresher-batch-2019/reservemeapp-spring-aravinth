package com.chainsys.reservemeapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.SeatStatusDAO;
import com.chainsys.reservemeapp.dao.impl.SeatStatusDAOImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.ServiceException;
import com.chainsys.reservemeapp.util.InfoMessages;

@Service
public class SeatStatusService {
	SeatStatusDAO obj = new SeatStatusDAOImpl();

	public void updatingSeats(int trainNum) throws ServiceException {
		try {
			obj.updatingSeats(trainNum);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.UPDATESEATS, e);
		}
	}

	public int AvailSeats(int trainNum) throws ServiceException {
		try {
			return obj.availableSeats(trainNum);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.SHOWSEATS, e);
		}
	}

}
