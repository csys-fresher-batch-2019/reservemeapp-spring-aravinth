package trainticket.AdminRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trainticket.Exception.DbException;
import trainticket.Exception.InfoMessages;

public class AdminListOfTrainsImpl implements AdminListOfTrainsDAO {

	public void addTrains(AdminListOfTrains l) throws DbException {
		try(Connection con = TestListTrains.connect();)
		{
		String sql = "insert into train_lists(train_name,train_num,source_station,destination_station,ticket_price,journey_date,travelling_time)values(?,?,?,?,?,?,?)";
		try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setString(1, l.getTrainname());
		pst.setInt(2, l.getTrainnum());
		pst.setString(3, l.getSourcestation());
		pst.setString(4, l.getDestinationstation());
		pst.setInt(5, l.getTicketPrice());
		java.sql.Date journeyDate = java.sql.Date.valueOf(l.getJourneyDate());
		pst.setDate(6, journeyDate);
		pst.setString(7, l.getTravellingTime());
		pst.executeUpdate();
		int trainNum = l.getTrainnum();
		String sql1 = "insert into seat_availabilities(train_num,tot_no_of_seats, no_of_seats_available) values(?,?,?)";
		try(PreparedStatement pst1 = con.prepareStatement(sql1);){
		pst1.setInt(1, trainNum);
		pst1.setInt(2, l.getTotNumOfSeats());
		pst1.setInt(3, l.getAvailableSeats());
		pst1.executeUpdate();
		System.out.println("Succesfully Train_lists added");
	}}
		catch(Exception e) {
			throw new DbException(InfoMessages.INSERTION);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
	}

	public void removeTrain(int trainNum) throws DbException {
		try(Connection con = TestListTrains.connect();
		Statement stmt=con.createStatement();)
		{
		String sql = "delete from seat_availabilities where train_num = "+trainNum;
		int qwert = stmt.executeUpdate(sql);
		String sql1 = "delete  from train_lists where train_num ="+trainNum;
		System.out.println(sql1);
		stmt.executeUpdate(sql);
		int sys  = stmt.executeUpdate(sql1);
		}
		catch(Exception e)
        {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);

		}

	}

	public void updateTimings(int trainNum, String travellingTime) throws DbException {
		try(Connection con = TestListTrains.connect();){
		String sql = "update train_lists set travelling_time =? where train_num = ?";
		try(PreparedStatement pst = con.prepareStatement(sql);){
		pst.setString(1,travellingTime);
		pst.setInt(2,trainNum);
		int rows = pst.executeUpdate();
		System.out.println("Succesfully Train Lists updated" + rows);
		}
		catch(Exception e) {
			throw new DbException(InfoMessages.UPDATTION);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);

		}

	}


	public List<String> getSourceStation() throws DbException {
		try(Connection con = TestListTrains.connect();
		Statement stmt=con.createStatement();){
		String sql = "select distinct source_station from train_lists";
		ArrayList<String> sourceList = new ArrayList<String>();
		try(ResultSet rs=stmt.executeQuery(sql);){
		while(rs.next()) {
			String a=rs.getString("source_station");
			sourceList.add(a);
		}
		
		return sourceList;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.SOURCE);

		}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
	}

	public List<String> getDestinationStation() throws DbException{
		try(Connection con = TestListTrains.connect();
		Statement stmt=con.createStatement();){
		String sql = "select distinct destination_station from train_lists";
		ArrayList<String> destinationList = new ArrayList<String>();
		try(ResultSet rs=stmt.executeQuery(sql);){
		while(rs.next()) {
			String a=rs.getString("destination_station");
			destinationList.add(a);
		}
		
		return destinationList;
		
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.DESTINATION);

		}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}

		
	}

}
