package com.chainsys.reservemeapp.dao;

import java.util.ArrayList;

import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.FindTrain;

public interface FindTrainDAO {
	public ArrayList<FindTrain> searchTrains(String a, String b, String c) throws DbException;
}
