package com.chainsys.reservemeapp.model;

public class AdminListOfTrains {
	@Override
	public String toString() {
		return "AdminListOfTrains [trainnum=" + trainNum + ", trainname=" + trainName + ", Sourcestation="
				+ sourceStation + ", Destinationstation=" + destinationStation + ", ticketPrice=" + ticketPrice
				+ ", journeyDate=" + journeyDate + ", travellingTime=" + travellingTime + "]";
	}

	private int trainNum;
	private String trainName;
	private String sourceStation;
	private String destinationStation;
	private int ticketPrice;
	private String journeyDate;
	private String travellingTime;
	private int totalNumOfSeats;
	private int availableSeats;

	public int getTrainnum() {
		return trainNum;
	}

	public void setTrainnum(int trainnum) {
		this.trainNum = trainnum;
	}

	public String getTrainname() {
		return trainName;
	}

	public void setTrainname(String trainname) {
		this.trainName = trainname;
	}

	public String getSourcestation() {
		return sourceStation;
	}

	public void setSourcestation(String sourcestation) {
		sourceStation = sourcestation;
	}

	public String getDestinationstation() {
		return destinationStation;
	}

	public void setDestinationstation(String destinationstation) {
		destinationStation = destinationstation;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getTravellingTime() {
		return travellingTime;
	}

	public void setTravellingTime(String travellingTime) {
		this.travellingTime = travellingTime;
	}

	public int getTotNumOfSeats() {
		return totalNumOfSeats;
	}

	public void setTotNumOfSeats(int totNumOfSeats) {
		this.totalNumOfSeats = totNumOfSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
}
