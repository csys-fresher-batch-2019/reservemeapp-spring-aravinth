package trainticket.passengerInfo;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trainticket.AdminRole.TestListTrains;

public class passengerInfoIMPL implements passengerInfoDAO {
	public int addPassenger(passengerInfo p1) {
		try (Connection con = TestListTrains.connect();) {
			String sql = "insert into passenger_details(train_num,user_id,booking_id,passenger_name,phone_number,no_of_tickets)values(?,?,booking_id.nextval,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, p1.getTrainNum());
				pst.setInt(2, p1.getUserId());
				pst.setString(3, p1.getPassengerName());
				pst.setLong(4, p1.getPhoneNumber());
				pst.setInt(5, p1.getNoOfTickets());
				pst.executeUpdate();

				System.out.println("Succesfully Passenger details added...");
				try(Statement stmt = con.createStatement();){

				String sql1 = "select booking_id.currval as current_value from dual";
				try(ResultSet rows = stmt.executeQuery(sql1);){
				rows.next();
				int bookingId = rows.getInt("current_value");
				/*String sql2 = "update seat_availabilities set no_of_seats_available = no_of_seats_available- "
						+ p1.getNoOfTickets() + " where train_num = ?";
				try(PreparedStatement pst1 = con.prepareStatement(sql2);){
				pst1.setInt(1, p1.getTrainNum());
				pst1.executeUpdate();*/
				String sql3 = "select ticket_price from train_lists where train_num =?";
				try(PreparedStatement pst2 = con.prepareStatement(sql3);){
				pst2.setInt(1, p1.getTrainNum());
				int cost = 0, ticket = 0;
				try (ResultSet row = pst2.executeQuery();) {
					if (row.next())
						cost = row.getInt("ticket_price");
					ticket = cost * p1.getNoOfTickets();
					try(Statement stmt1 = con.createStatement();){
					String sql22 = "insert into payment_status(train_num,user_id,booking_id,tot_ticket_price)values("
							+ p1.getTrainNum() + "," + p1.getUserId() + "," + bookingId + "," + ticket + ")";
					stmt1.executeUpdate(sql22);
					con.close();
					return bookingId;
				}}
				//}
			}}}}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<passengerInfo> BookingDetails(int bookingId) {
		try (Connection con = TestListTrains.connect();) {
			String sql6 ="select * from passenger_details where booking_id =?";
			try(PreparedStatement pst3 = con.prepareStatement(sql6);)
			{
				pst3.setInt(1,bookingId );
				try(ResultSet rows = pst3.executeQuery();)
				{
					ArrayList<passengerInfo> details = new ArrayList<passengerInfo>();
					while(rows.next()) {
						passengerInfo p =  new passengerInfo();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public int totalPrice(int bookingId) {
		try (Connection con = TestListTrains.connect();) {
			String sql = "select tot_ticket_price from payment_status where booking_id = ?";
			try(PreparedStatement pst = con.prepareStatement(sql);){
				pst.setInt(1,bookingId );
				try(ResultSet row = pst.executeQuery();){
					int price = 0;
					if(row.next()) {
						price = row.getInt("tot_ticket_price");
					}
					return price;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;

		}
	}
	public boolean validateBookingId(int bookingId) {

		try (Connection con = TestListTrains.connect();) {
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
		return false;
		}

		}

		public boolean validateTrainNum(int trainNum) {
		try (Connection con = TestListTrains.connect();) {
		String train = "select train_num from train_lists where train_num = ?";
		try (PreparedStatement smt9 = con.prepareStatement(train);) {
		smt9.setInt(1, trainNum);
		try(ResultSet row9 = smt9.executeQuery();){
		int trainnum = 0;
		if (row9.next()) {
		trainnum = row9.getInt("train_num");
		}
		if (trainNum == trainnum) {

		return true;
		} else {

		return false;
		}

		}}
		} catch (SQLException e) {

		e.printStackTrace();
		return false;

		}

		}

		@Override
		public ArrayList<passengerInfo> ticketDetails(int userId) {
			try (Connection con = TestListTrains.connect();) {
				String sql6 ="select * from passenger_details where user_id =?";
				try(PreparedStatement pst3 = con.prepareStatement(sql6);)
				{
					pst3.setInt(1,userId );
					try(ResultSet rows = pst3.executeQuery();)
					{
						ArrayList<passengerInfo> details = new ArrayList<passengerInfo>();
						while(rows.next()) {
							passengerInfo p =  new passengerInfo();
							p.setBookingId(rows.getInt("booking_id"));
							//p.setUserId(rows.getInt("user_id"));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;

			}

		}
	
}
