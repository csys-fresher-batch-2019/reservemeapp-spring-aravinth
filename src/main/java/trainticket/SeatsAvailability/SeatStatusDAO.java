package trainticket.SeatsAvailability;

import trainticket.Exception.DbException;

public interface SeatStatusDAO {
	public void updatingSeats(int trainNum) throws DbException;
	public int AvailSeats(int trainNum) throws DbException;
}
