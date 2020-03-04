package com.chainsys.reservemeapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.reservemeapp.dao.SeatStatusDAO;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.InfoMessages;
import com.chainsys.reservemeapp.util.TestConnection;

public class SeatStatusIMPL implements SeatStatusDAO {
	public void updatingSeats(int trainNum) throws DbException {
		 try(Connection con = TestConnection.connect();){
		 String sql = "update seat_availabilities set no_of_seats_available = ( tot_no_of_seats- (select sum(no_of_tickets) from passenger_details where train_num = ? and book_status = 'booked'))where train_num = ?";
		 try(PreparedStatement pst = con.prepareStatement(sql);){
		   pst.setInt(1,trainNum);
		   pst.setInt(2,trainNum);
		   pst.executeUpdate();
		   System.out.println("Successfully Available Seats Are Updated");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 throw new DbException(InfoMessages.UPDATESEATS);
		 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 throw new DbException(InfoMessages.CONNECTION);
		 }
	}

	public int AvailSeats(int trainNum) throws DbException {
		try(Connection con = TestConnection.connect();){
		String sql ="select no_of_seats_available from seat_availabilities where train_num =?";
		try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setInt(1, trainNum);
		int seats = 0;
		try(ResultSet row = pst.executeQuery();){
		if(row.next())
		{
			seats = row.getInt("no_of_seats_available");
		}
		return seats;
		}}
		catch(Exception e)
		{
			e.printStackTrace();
			 throw new DbException(InfoMessages.SHOWSEATS);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 throw new DbException(InfoMessages.CONNECTION);
		}
	}

	

	
}
