package com.chainsys.reservemeapp.model;

public class FindTrain {
	private int trainNum;
	private String trainName;
	private int price;
	private String travellingTime;
	private int seats;

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getTrain_num() {
		return trainNum;
	}

	public void setTrain_num(int train_num) {
		this.trainNum = train_num;
	}

	public String getTrain_name() {
		return trainName;
	}

	public void setTrain_name(String train_name) {
		this.trainName = train_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTravelling_time() {
		return travellingTime;
	}

	public void setTravelling_time(String travelling_time) {
		this.travellingTime = travelling_time;
	}

	public FindTrain(int train_num, String train_name, int price, String travelling_time) {
		super();
		this.trainNum = train_num;
		this.trainName = train_name;
		this.price = price;
		this.travellingTime = travelling_time;
	}

	public FindTrain() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "findTrain [train_num=" + trainNum + ", train_name=" + trainName + ", price=" + price
				+ ", travelling_time=" + travellingTime + ", seats=" + seats + "]";
	}

}
