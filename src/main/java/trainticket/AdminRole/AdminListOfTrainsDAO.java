package trainticket.AdminRole;

import java.util.ArrayList;
import java.util.List;

public interface AdminListOfTrainsDAO {
	
	public void addTrains(AdminListOfTrains l);
	
	public void removeTrain(int trainNum);
	
	public void updateTimings(int train_num,String TravellingTime);
	
	public void addPromo(String PromoCode,int discountValue);
	
	public List<String> getSourceStation();
	public List<String> getDestinationStation();

	
}
