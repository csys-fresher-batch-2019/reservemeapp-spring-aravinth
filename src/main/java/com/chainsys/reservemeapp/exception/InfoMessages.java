package com.chainsys.reservemeapp.exception;

public class InfoMessages {
	private InfoMessages() {
		throw new IllegalStateException("Utility class");
	}

	public static final String CONNECTION = "Unable to establish connection 'SERVER ERROR'";
	public static final String UPDATTION = "Unable to Update the Train Lists";
	public static final String INSERTION = "Unable to Insert the Lists";
	public static final String SOURCE = "Unable to Show Source Station";
	public static final String DESTINATION = "Unable to Show Destination Station";
	public static final String ADDINGACCOUNT = "Unable to add Account";
	public static final String LOGIN = "Invalid UserId/Password";
	public static final String CHECKDATA = "Invalid UserId/EmailId";
	public static final String ADDINGPASSENGER = "Unable to add Passenger";
	public static final String BOOKINGS = "Unable to Show Booking Details";
	public static final String PRICE = "Unable to Show Total Price";
	public static final String BOOKINGIDCHECK = "Invalid BookingID";
	public static final String INVALIDTRAINNUM = "Invalid TrainNum";
	public static final String UPDATEPAYMENT = "Unable to Update the Payment Details";
	public static final String FINDTRAIN = "Unable to Find Train lists";
	public static final String UPDATESEATS = "Unable to Update the Train Seats";
	public static final String SHOWSEATS = "Unable to Show Train Seats";

}
