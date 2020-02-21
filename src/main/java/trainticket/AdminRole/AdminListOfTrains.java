package trainticket.AdminRole;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public class AdminListOfTrains {
	@Override
	public String toString() {
		return "AdminListOfTrains [trainnum=" + trainnum + ", trainname=" + trainname + ", Sourcestation="
				+ Sourcestation + ", Destinationstation=" + Destinationstation + ", ticketPrice=" + ticketPrice
				+ ", journeyDate=" + journeyDate + ", travellingTime=" + travellingTime + "]";
	}
	private int trainnum;
	private String trainname;
	private String Sourcestation;
	private String Destinationstation;
	private int ticketPrice;
	private String journeyDate;
	private String travellingTime;
	private int totNumOfSeats;
	private int availableSeats;
	public int getTrainnum() {
		return trainnum;
	}
	public void setTrainnum(int trainnum) {
		this.trainnum = trainnum;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	public String getSourcestation() {
		return Sourcestation;
	}
	public void setSourcestation(String sourcestation) {
		Sourcestation = sourcestation;
	}
	public String getDestinationstation() {
		return Destinationstation;
	}
	public void setDestinationstation(String destinationstation) {
		Destinationstation = destinationstation;
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


