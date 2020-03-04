package com.chainsys.reservemeapp.dao;

import java.util.ArrayList;

import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.findTrain;

public interface findTrainDAO {
	public ArrayList<findTrain>SearchTrain(String a,String b,String c) throws DbException;
}
