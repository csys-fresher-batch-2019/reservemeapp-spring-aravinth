package com.chainsys.reservemeapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.reservemeapp.dao.TrainDTO;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.TrainDto;
import com.chainsys.reservemeapp.util.ConnectionUtil;
import com.chainsys.reservemeapp.util.InfoMessages;

public class TrainDTOImpl implements TrainDTO {

	public ArrayList<TrainDto> searchTrains(String sourceStation, String destinationStation, String journeyDate)
			throws DbException {
		ArrayList<TrainDto> trains = new ArrayList<>();
		try (Connection con = ConnectionUtil.connect();) {

			String sql = "select train_name,tl.train_num,ticket_price,travelling_time,no_of_seats_available from train_lists tl, seat_availabilities sa where source_station =? and destination_station= ? and  journey_date=?"
					+ "  and  sa.train_num  = tl.train_num and no_of_seats_available > 0";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setString(1, sourceStation);
				pst.setString(2, destinationStation);
				java.sql.Date journey = java.sql.Date.valueOf(journeyDate);
				pst.setDate(3, journey);
				try (ResultSet rows = pst.executeQuery();) {
					while (rows.next()) {

						TrainDto f = new TrainDto();

						f.setTrainName(rows.getString("train_name"));
						f.setTrainNum(rows.getInt("train_num"));
						f.setPrice(rows.getInt("ticket_price"));
						f.setTravellingTime(rows.getString("travelling_time"));

						f.setSeats(rows.getInt("no_of_seats_available"));
						trains.add(f);

					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.FINDTRAIN, e);
		}

		return trains;
	}

}
