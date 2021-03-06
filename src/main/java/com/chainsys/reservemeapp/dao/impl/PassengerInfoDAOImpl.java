package com.chainsys.reservemeapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.reservemeapp.dao.PassengerInfoDAO;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.PassengerInfo;
import com.chainsys.reservemeapp.util.ConnectionUtil;
import com.chainsys.reservemeapp.util.InfoMessages;

public class PassengerInfoDAOImpl implements PassengerInfoDAO {
	public int addPassenger(PassengerInfo p1) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql = "insert into passenger_details(train_num,user_id,booking_id,passenger_name,phone_number,no_of_tickets)values(?,?,booking_id.nextval,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, p1.getTrainNum());
				pst.setInt(2, p1.getUserId());
				pst.setString(3, p1.getPassengerName());
				pst.setLong(4, p1.getPhoneNumber());
				pst.setInt(5, p1.getNoOfTickets());
				pst.executeUpdate();
				int trainNum = p1.getTrainNum();
				int totTickets = p1.getNoOfTickets();
				int userId = p1.getUserId();
				int bookingId = showBookingId(userId);
				int totTicketPrice = showTicketPrice(trainNum, totTickets);
				updatePaymentSts(trainNum, totTicketPrice, bookingId, userId);
				con.close();
				return bookingId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.ADDINGPASSENGER, e);
		}
	}

	private void updatePaymentSts(int trainNum, int totTicketPrice, int bookingId, int userId) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql22 = "insert into payment_status(train_num,user_id,booking_id,tot_ticket_price)values(?,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(sql22);) {
				pst.setInt(1, trainNum);
				pst.setInt(2, userId);
				pst.setInt(3, bookingId);
				pst.setInt(4, totTicketPrice);
				pst.executeUpdate();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.UPDATE_PAYMENT, e);
		}

	}

	private int showBookingId(int userId) throws DbException {
		int bookingId = 0;
		try (Connection con = ConnectionUtil.connect();) {
			String sql1 = "select max(booking_id) as id from passenger_details where user_id =?";
			try (PreparedStatement pst = con.prepareStatement(sql1);) {
				pst.setInt(1, userId);
				try (ResultSet rows = pst.executeQuery();) {
					rows.next();
					bookingId = rows.getInt("id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.BOOKING_ID, e);
		}
		return bookingId;
	}

	private int showTicketPrice(int trainNum, int totTickets) throws DbException {
		int totTicketPrice = 0;
		try (Connection con = ConnectionUtil.connect();) {
			String sql3 = "select ticket_price from train_lists where train_num =?";
			try (PreparedStatement pst2 = con.prepareStatement(sql3);) {
				pst2.setInt(1, trainNum);
				int cost = 0;
				try (ResultSet row = pst2.executeQuery();) {
					if (row.next())
						cost = row.getInt("ticket_price");
					totTicketPrice = cost * totTickets;
					con.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.TICKET_PRICE, e);
		}
		return totTicketPrice;
	}

	@Override
	public ArrayList<PassengerInfo> bookingDetails(int bookingId) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql6 = "select * from passenger_details where booking_id =?";
			try (PreparedStatement pst3 = con.prepareStatement(sql6);) {
				pst3.setInt(1, bookingId);
				try (ResultSet rows = pst3.executeQuery();) {
					ArrayList<PassengerInfo> details = new ArrayList<PassengerInfo>();
					while (rows.next()) {
						PassengerInfo p = new PassengerInfo();
						p.setBookingId(rows.getInt("booking_id"));
						p.setUserId(rows.getInt("user_id"));
						p.setTrainNum(rows.getInt("train_num"));
						p.setPassengerName(rows.getString("passenger_name"));
						p.setPhoneNumber(rows.getLong("phone_number"));
						p.setNoOfTickets(rows.getInt("no_of_tickets"));
						details.add(p);
					}
					return details;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.BOOKINGS, e);
		}
	}

	public boolean validateBookingId(int bookingId) throws DbException {

		try (Connection con = ConnectionUtil.connect();) {
			String bId = "select booking_id from passenger_details where booking_id=?";
			try (PreparedStatement smt = con.prepareStatement(bId);) {
				smt.setInt(1, bookingId);
				try (ResultSet row = smt.executeQuery();) {
					int bookid = 0;
					if (row.next()) {
						bookid = row.getInt("booking_id");
					}
					if (bookid == bookingId) {

						return true;
					} else {

						return false;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.BOOKINGIDCHECK, e);
		}

	}

	public boolean validateTrainNum(int trainNum) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String train = "select train_num from train_lists where train_num = ?";
			try (PreparedStatement smt9 = con.prepareStatement(train);) {
				smt9.setInt(1, trainNum);
				try (ResultSet row9 = smt9.executeQuery();) {
					int trainNum1 = 0;
					if (row9.next()) {
						trainNum1 = row9.getInt("train_num");
						return true;
					} else {

						return false;
					}

				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DbException(InfoMessages.INVALIDTRAINNUM, e);
		}

	}

	@Override
	public ArrayList<PassengerInfo> ticketDetails(int userId) throws DbException {
		try (Connection con = ConnectionUtil.connect();) {
			String sql6 = "select booking_id,train_num,passenger_name,phone_number,no_of_tickets,book_status from passenger_details where user_id =?";
			try (PreparedStatement pst3 = con.prepareStatement(sql6);) {
				pst3.setInt(1, userId);
				try (ResultSet rows = pst3.executeQuery();) {
					ArrayList<PassengerInfo> details = new ArrayList<PassengerInfo>();
					while (rows.next()) {
						PassengerInfo p = new PassengerInfo();
						p.setBookingId(rows.getInt("booking_id"));
						p.setTrainNum(rows.getInt("train_num"));
						p.setPassengerName(rows.getString("passenger_name"));
						p.setPhoneNumber(rows.getLong("phone_number"));
						p.setNoOfTickets(rows.getInt("no_of_tickets"));
						p.setBookStatus(rows.getString("book_status"));
						details.add(p);
					}
					return details;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.BOOKINGS, e);
		}

	}

}
