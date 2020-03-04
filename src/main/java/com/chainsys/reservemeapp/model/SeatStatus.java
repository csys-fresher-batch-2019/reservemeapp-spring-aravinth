package com.chainsys.reservemeapp.model;

public class SeatStatus {
	private int trainNum;
	private int totNumOfSeats;
	private int availableSeats;
	public int getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(int trainNum) {
		this.trainNum = trainNum;
	}
	public int getTotNumOfSeats() {
		return totNumOfSeats;
	}
	public void setTotNumOfSeats(int totNumOfSeats) {
		this.totNumOfSeats = totNumOfSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

}
