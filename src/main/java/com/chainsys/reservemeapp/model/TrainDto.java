package com.chainsys.reservemeapp.model;

public class TrainDto {
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

	public int getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(int train_num) {
		this.trainNum = train_num;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String train_name) {
		this.trainName = train_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTravellingTime() {
		return travellingTime;
	}

	public void setTravellingTime(String travelling_time) {
		this.travellingTime = travelling_time;
	}

	public TrainDto(int train_num, String train_name, int price, String travelling_time) {
		super();
		this.trainNum = train_num;
		this.trainName = train_name;
		this.price = price;
		this.travellingTime = travelling_time;
	}

	public TrainDto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "findTrain [train_num=" + trainNum + ", train_name=" + trainName + ", price=" + price
				+ ", travelling_time=" + travellingTime + ", seats=" + seats + "]";
	}

}
