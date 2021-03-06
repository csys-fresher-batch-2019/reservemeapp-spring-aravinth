package com.chainsys.reservemeapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.reservemeapp.dao.PaymentDAO;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.util.ConnectionUtil;
import com.chainsys.reservemeapp.util.InfoMessages;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public boolean paymentMethod(int bookingId, String paySts, String paymentMode) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql = "update payment_status set pay_status =?,payment_mode=? where booking_id = ?  ";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setString(1, paySts);
				pst.setString(2, paymentMode);
				pst.setInt(3, bookingId);
				pst.executeUpdate();
				updateBookStatus(bookingId);
				updateSeatStatus(bookingId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.UPDATE_PAYMENT, e);
		}
		return false;
	}

	private boolean updateBookStatus(int bookingId) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql2 = "update passenger_details set book_status = 'booked' where booking_id =?";
			try (PreparedStatement pst1 = con.prepareStatement(sql2);) {
				pst1.setInt(1, bookingId);
				pst1.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.UPDATE_PAYMENT, e);
		}
		return false;
	}

	private boolean updateSeatStatus(int bookingId) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql3 = "update seat_availabilities set no_of_seats_available = ( tot_no_of_seats- (select sum( no_of_tickets) from passenger_details where train_num = (select train_num from passenger_details where booking_id = ?)))where train_num=(select train_num from passenger_details where booking_id = ?) ";
			try (PreparedStatement pst3 = con.prepareStatement(sql3);) {
				pst3.setInt(1, bookingId);
				pst3.setInt(2, bookingId);
				pst3.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.UPDATESEATS, e);
		}
		return false;
	}

	// For payment failure method pay_sts = 'failure' and book_sts = 'cancelled';
	@Override
	public int totTicketPrice(int bookingId) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql1 = "select tot_ticket_price from payment_status where booking_id =?";
			try (PreparedStatement pst = con.prepareStatement(sql1);) {
				pst.setInt(1, bookingId);
				pst.executeQuery();
				int price = 0;
				try (ResultSet row = pst.executeQuery();) {
					if (row.next()) {
						price = row.getInt("tot_ticket_price");
					}
					return price;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.PRICE, e);

		}

	}

}
