package com.chainsys.reservemeapp.searchingtrain;

public class findTrain {
		private int train_num;
		private String train_name;
		private int price;
		private String travelling_time;
		private int seats;

		public int getSeats() {
			return seats;
		}

		public void setSeats(int seats) {
			this.seats = seats;
		}

		public int getTrain_num() {
			return train_num;
		}

		public void setTrain_num(int train_num) {
			this.train_num = train_num;
		}

		public String getTrain_name() {
			return train_name;
		}

		public void setTrain_name(String train_name) {
			this.train_name = train_name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getTravelling_time() {
			return travelling_time;
		}

		public void setTravelling_time(String travelling_time) {
			this.travelling_time = travelling_time;
		}

		public findTrain(int train_num, String train_name, int price, String travelling_time) {
			super();
			this.train_num = train_num;
			this.train_name = train_name;
			this.price = price;
			this.travelling_time = travelling_time;
		}
		
		public findTrain() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "findTrain [train_num=" + train_num + ", train_name=" + train_name + ", price=" + price
					+ ", travelling_time=" + travelling_time + ", seats=" + seats + "]";
		}

	}
