package com.chainsys.reservemeapp.model;

public class Payment {
	private int trainNum;
	private int userId;
	private int bookingId;
	private int totalTicketPrice;
	private String payStatus;
	private int transactionId;

	public int getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getTotalTicketPrice() {
		return totalTicketPrice;
	}

	public void setTotTicketPrice(int totTicketPrice) {
		this.totalTicketPrice = totTicketPrice;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

}
