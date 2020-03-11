package com.chainsys.reservemeapp.model;

public class Trains {
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

	public int getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(int trainnum) {
		this.trainNum = trainnum;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainname) {
		this.trainName = trainname;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourcestation) {
		sourceStation = sourcestation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationstation) {
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
