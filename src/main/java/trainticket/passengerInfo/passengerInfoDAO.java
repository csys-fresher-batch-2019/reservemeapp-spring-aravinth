package trainticket.passengerInfo;

import java.util.ArrayList;

import trainticket.Exception.DbException;

public interface passengerInfoDAO {
	public int addPassenger(passengerInfo p1) throws DbException; 
	public ArrayList<passengerInfo> BookingDetails(int bookingId) throws DbException;
	public int totalPrice(int bookingId) throws DbException;
	public boolean validateBookingId(int bookingId) throws DbException;
	public boolean validateTrainNum(int trainNum) throws DbException;
	public ArrayList<passengerInfo>ticketDetails(int userId) throws DbException;
}
