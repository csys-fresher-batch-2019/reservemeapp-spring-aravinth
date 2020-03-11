package com.chainsys.reservemeapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.PassengerInfoDAO;
import com.chainsys.reservemeapp.dao.impl.PassengerInfoImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.PassengerInfo;

@Service
public class PassengerInfoService {
	PassengerInfoDAO obj = new PassengerInfoImpl();

	public int addPassenger(PassengerInfo p1) throws DbException {
		return obj.addPassenger(p1);
	}

	public ArrayList<PassengerInfo> BookingDetails(int bookingId) throws DbException {
		return obj.bookingDetails(bookingId);
	}

	public int totalPrice(int bookingId) throws DbException {
		return obj.totalPrice(bookingId);
	}

	public boolean validateBookingId(int bookingId) throws DbException {
		return obj.validateBookingId(bookingId);
	}

	public boolean validateTrainNum(int trainNum) throws DbException {
		return obj.validateTrainNum(trainNum);
	}

	public ArrayList<PassengerInfo> ticketDetails(int userId) throws DbException {
		return obj.ticketDetails(userId);
	}

}
