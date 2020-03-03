package com.chainsys.reservemeapp.searchingtrain;

import java.util.ArrayList;

import com.chainsys.reservemeapp.exception.DbException;

public interface findTrainDAO {
	public ArrayList<findTrain>SearchTrain(String a,String b,String c) throws DbException;
}
