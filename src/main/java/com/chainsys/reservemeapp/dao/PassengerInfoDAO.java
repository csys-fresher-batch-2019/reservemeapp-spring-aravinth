package com.chainsys.reservemeapp.dao;

import java.util.ArrayList;

import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.PassengerInfo;

public interface PassengerInfoDAO {
	public int addPassenger(PassengerInfo p1) throws DbException;

	public ArrayList<PassengerInfo> bookingDetails(int bookingId) throws DbException;

	public int totalPrice(int bookingId) throws DbException;

	public boolean validateBookingId(int bookingId) throws DbException;

	public boolean validateTrainNum(int trainNum) throws DbException;

	public ArrayList<PassengerInfo> ticketDetails(int userId) throws DbException;
}
