package com.chainsys.reservemeapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.reservemeapp.dao.TrainsDAO;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.Trains;
import com.chainsys.reservemeapp.util.ConnectionUtil;
import com.chainsys.reservemeapp.util.InfoMessages;

public class TrainsDAOImpl implements TrainsDAO {

	public void addTrain(Trains l) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql = "insert into train_lists(train_name,train_num,Source_station,Destination_station,ticket_price,journey_date,travelling_time)values(?,?,?,?,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setString(1, l.getTrainName());
				pst.setInt(2, l.getTrainNum());
				pst.setString(3, l.getSourceStation());
				pst.setString(4, l.getDestinationStation());
				pst.setInt(5, l.getTicketPrice());
				java.sql.Date journeyDate = java.sql.Date.valueOf(l.getJourneyDate());
				pst.setDate(6, journeyDate);
				pst.setString(7, l.getTravellingTime());
				pst.executeUpdate();
				int trainNum = l.getTrainNum();
				int totSeats = l.getTotNumOfSeats();
				int availableSeats = l.getAvailableSeats();
				addTrainSeats(trainNum, totSeats, availableSeats);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.TRAIN_INSERTION, e);
		}
	}

	private void addTrainSeats(int trainNum, int totSeats, int availableSeats) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql1 = "insert into seat_availabilities(train_num,tot_no_of_seats, no_of_seats_available) values(?,?,?)";
			try (PreparedStatement pst1 = con.prepareStatement(sql1);) {
				pst1.setInt(1, trainNum);
				pst1.setInt(2, totSeats);
				pst1.setInt(3, availableSeats);
				pst1.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.TRAIN_SEATS_INSERTION, e);
		}
	}

	public void removeTrain(int trainNum) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql1 = "delete  from train_lists where train_num =?";
			try (PreparedStatement pst = con.prepareStatement(sql1);) {
				pst.setInt(1, trainNum);
				pst.executeUpdate();
				removeTrainSeats(trainNum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.DELETE_TRAINS, e);
		}

	}

	private void removeTrainSeats(int trainNum) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql = "delete from seat_availabilities where train_num = ?";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, trainNum);
				pst.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.DELETE_SEATS, e);

		}

	}

	public List<String> getSourceStation() throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql = "select distinct source_station from train_lists";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				List<String> sourceList = new ArrayList<>();
				try (ResultSet rs = pst.executeQuery(sql);) {
					while (rs.next()) {
						String a = rs.getString("source_station");
						sourceList.add(a);
					}

					return sourceList;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.SOURCE, e);
		}
	}

	public List<String> getDestinationStation() throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql = "select distinct destination_station from train_lists";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				List<String> destinationList = new ArrayList<>();
				try (ResultSet rs = pst.executeQuery(sql);) {
					while (rs.next()) {
						String a = rs.getString("destination_station");
						destinationList.add(a);
					}

					return destinationList;

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.DESTINATION, e);
		}

	}

}
