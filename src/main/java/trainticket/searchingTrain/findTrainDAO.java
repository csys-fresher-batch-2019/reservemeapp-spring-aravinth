package trainticket.searchingTrain;

import java.util.ArrayList;

import trainticket.Exception.DbException;

public interface findTrainDAO {
	public ArrayList<findTrain>SearchTrain(String a,String b,String c) throws DbException;
}
