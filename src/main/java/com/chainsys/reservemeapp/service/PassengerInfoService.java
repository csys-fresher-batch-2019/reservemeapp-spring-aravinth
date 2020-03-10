package com.chainsys.reservemeapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.passengerInfoDAO;
import com.chainsys.reservemeapp.dao.impl.passengerInfoIMPL;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.passengerInfo;

@Service
public class PassengerInfoService {
	passengerInfoDAO obj = new passengerInfoIMPL();

	public int addPassenger(passengerInfo p1) throws DbException {
		return obj.addPassenger(p1);
	}

	public ArrayList<passengerInfo> BookingDetails(int bookingId) throws DbException {
		return obj.BookingDetails(bookingId);
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

	public ArrayList<passengerInfo> ticketDetails(int userId) throws DbException {
		return obj.ticketDetails(userId);
	}

}
