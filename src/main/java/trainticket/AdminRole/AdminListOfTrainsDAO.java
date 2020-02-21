package trainticket.AdminRole;

import java.util.List;

import trainticket.Exception.DbException;

public interface AdminListOfTrainsDAO {
	
	public void addTrains(AdminListOfTrains l) throws DbException;	
	public void removeTrain(int trainNum) throws DbException;	
	public void updateTimings(int train_num,String TravellingTime) throws DbException;	
	public List<String> getSourceStation() throws DbException;
	public List<String> getDestinationStation() throws DbException;	
}
