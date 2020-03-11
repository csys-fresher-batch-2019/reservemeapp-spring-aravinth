package com.chainsys.reservemeapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.PassengerInfoDAO;
import com.chainsys.reservemeapp.dao.impl.PassengerInfoDAOImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.ServiceException;
import com.chainsys.reservemeapp.model.PassengerInfo;
import com.chainsys.reservemeapp.util.InfoMessages;

@Service
public class PassengerInfoService {
	PassengerInfoDAO obj = new PassengerInfoDAOImpl();

	public int addPassenger(PassengerInfo p1) throws ServiceException {
		try {
			return obj.addPassenger(p1);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.ADDINGPASSENGER, e);
		}
	}

	public List<PassengerInfo> BookingDetails(int bookingId) throws ServiceException {
		try {
			return obj.bookingDetails(bookingId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.BOOKINGS, e);
		}
	}

	public boolean validateBookingId(int bookingId) throws ServiceException {
		try {
			return obj.validateBookingId(bookingId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.BOOKINGIDCHECK, e);
		}
	}

	public boolean validateTrainNum(int trainNum) throws ServiceException {
		try {
			return obj.validateTrainNum(trainNum);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.INVALIDTRAINNUM, e);
		}
	}

	public List<PassengerInfo> ticketDetails(int userId) throws ServiceException {
		try {
			return obj.ticketDetails(userId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.BOOKINGS, e);
		}
	}

}
