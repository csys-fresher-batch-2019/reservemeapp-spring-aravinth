package trainticket.passengerInfo;

import java.util.ArrayList;

public interface passengerInfoDAO {
	public int addPassenger(passengerInfo p1); 
	public ArrayList<passengerInfo> BookingDetails(int bookingId);
	public int totalPrice(int bookingId);
	public boolean validateBookingId(int bookingId);
	public boolean validateTrainNum(int trainNum);
	public ArrayList<passengerInfo>ticketDetails(int userId);
}
