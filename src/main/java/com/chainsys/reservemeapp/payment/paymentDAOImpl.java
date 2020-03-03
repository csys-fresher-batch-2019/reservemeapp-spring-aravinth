package com.chainsys.reservemeapp.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.reservemeapp.adminrole.TestListTrains;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.InfoMessages;

public class paymentDAOImpl implements paymentDAO {

	@Override
	public boolean paymentSuccess(int bookingId) throws DbException {
		try (Connection con = TestListTrains.connect();) {
			String sql ="update payment_status set pay_status ='paid',payment_mode='creditcard' where booking_id = ?  ";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1,bookingId );
				pst.executeUpdate();
				String sql2 = "update passenger_details set book_status = 'booked' where booking_id =?";
				try (PreparedStatement pst1 = con.prepareStatement(sql2);) {
					pst1.setInt(1,bookingId);
					pst1.executeUpdate();
					String sql3 = "update seat_availabilities set no_of_seats_available = ( tot_no_of_seats- (select sum( no_of_tickets) from passenger_details where train_num = (select train_num from passenger_details where booking_id = ?)))where train_num=(select train_num from passenger_details where booking_id = ?) "; 
					try (PreparedStatement pst3 = con.prepareStatement(sql3);) {
						pst3.setInt(1, bookingId);
						pst3.setInt(2,bookingId);
						pst3.executeUpdate();
					}

				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.UPDATEPAYMENT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
		return false;
	}
	@Override
	public boolean paymentFailure(int bookingId) throws DbException {
		try(Connection con = TestListTrains.connect();){
			String sql3 = "update payment_status  set pay_status = 'failure' where booking_id =?";
			try(PreparedStatement pst = con.prepareStatement(sql3);)
			{
				pst.setInt(1,bookingId);
				pst.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.UPDATEPAYMENT);
			}
			String sql4 = "update passenger_details set booking_status = 'cancelled' where booking_id = ?";
			try(PreparedStatement pst = con.prepareStatement(sql4);)
			{
				pst.setInt(1,bookingId);
				pst.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.UPDATEPAYMENT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
		return false;
	}

	@Override
	public int totTicPrice(int bookingId) throws DbException {
		try (Connection con = TestListTrains.connect();) {
			String sql1 = "select tot_ticket_price from payment_status where booking_id =?";
			try (PreparedStatement pst = con.prepareStatement(sql1);) {
				pst.setInt(1, bookingId);
				pst.executeQuery();
				int price = 0;
				try(ResultSet row = pst.executeQuery();){
					if(row.next())
					{
						price = row.getInt("tot_ticket_price");					
			}
					return price;
				}
	}
			catch (SQLException e1) {
				e1.printStackTrace();
				throw new DbException(InfoMessages.PRICE);
			}	
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);

		}
		
	}

	@Override
	public boolean cashPay(int bookingId, String paymentMode) throws DbException {
		
		System.out.println("Payment Mode:" + paymentMode);
		String paymentStatus = "pending";
		try (Connection con = TestListTrains.connect();) {
			String sql ="update payment_status set pay_status =?, payment_mode=? where booking_id = ?  ";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setString(1, paymentStatus);
				pst.setString(2, paymentMode);
				pst.setInt(3,bookingId );
				int rows = pst.executeUpdate();
				System.out.println("Update payment status" + rows);
				String sql2 = "update passenger_details set book_status = 'booked' where booking_id =?";
				try (PreparedStatement pst1 = con.prepareStatement(sql2);) {
					pst1.setInt(1,bookingId);
					pst1.executeUpdate();
					String sql3 = "update seat_availabilities set no_of_seats_available = ( tot_no_of_seats- (select sum( no_of_tickets) from passenger_details where train_num = (select train_num from passenger_details where booking_id = ?)))where train_num=(select train_num from passenger_details where booking_id = ?) "; 
					try (PreparedStatement pst3 = con.prepareStatement(sql3);) {
						pst3.setInt(1, bookingId);
						pst3.setInt(2,bookingId);
						pst3.executeUpdate();
					}

				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.UPDATEPAYMENT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
		return false;
	}

	
}
