package com.chainsys.reservemeapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.chainsys.reservemeapp.dao.findTrainDAO;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.InfoMessages;
import com.chainsys.reservemeapp.model.findTrain;
import com.chainsys.reservemeapp.util.TestConnection;

public class findTrainIMPL implements findTrainDAO {

	public ArrayList<findTrain> SearchTrain(String sourceStation, String destinationStation, String journeyDate)
			throws DbException {
		ArrayList<findTrain> trains = new ArrayList<>();
		try (Connection con = TestConnection.connect();) {

			String sql = "select train_name,tl.train_num,ticket_price,travelling_time,no_of_seats_available from train_lists tl, seat_availabilities sa where source_station =? and destination_station= ? and  journey_date=?"
					+ "  and  sa.train_num  = tl.train_num and no_of_seats_available > 0";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setString(1, sourceStation);
				pst.setString(2, destinationStation);
				java.sql.Date journey = java.sql.Date.valueOf(journeyDate);
				pst.setDate(3, journey);
				try (ResultSet rows = pst.executeQuery();) {
					while (rows.next()) {

						findTrain f = new findTrain();

						f.setTrain_name(rows.getString("train_name"));
						f.setTrain_num(rows.getInt("train_num"));
						f.setPrice(rows.getInt("ticket_price"));
						f.setTravelling_time(rows.getString("travelling_time"));

						f.setSeats(rows.getInt("no_of_seats_available"));
						trains.add(f);

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.FINDTRAIN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}

		return trains;
	}

}
