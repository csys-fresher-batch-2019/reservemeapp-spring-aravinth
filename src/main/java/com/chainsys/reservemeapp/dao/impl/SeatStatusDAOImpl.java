package com.chainsys.reservemeapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.reservemeapp.dao.SeatStatusDAO;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.util.ConnectionUtil;
import com.chainsys.reservemeapp.util.InfoMessages;

public class SeatStatusDAOImpl implements SeatStatusDAO {
	public void updatingSeats(int trainNum) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql = "update seat_availabilities set no_of_seats_available = ( tot_no_of_seats- (select sum(no_of_tickets) from passenger_details where train_num = ? and book_status = 'booked'))where train_num = ?";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, trainNum);
				pst.setInt(2, trainNum);
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.UPDATESEATS, e);
		}
	}

	public int availableSeats(int trainNum) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql = "select no_of_seats_available from seat_availabilities where train_num =?";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, trainNum);
				int seats = 0;
				try (ResultSet row = pst.executeQuery();) {
					if (row.next()) {
						seats = row.getInt("no_of_seats_available");
					}
					return seats;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.SHOWSEATS, e);
		}
	}

}
