package trainticket.SeatsAvailability;

public interface SeatStatusDAO {
	public void updatingSeats(int trainNum);
	//public void AddingSeats(SeatStatus s) throws Exception;
	public int AvailSeats(int trainNum);
}
