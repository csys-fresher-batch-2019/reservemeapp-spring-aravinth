package com.chainsys.reservemeapp.dao;

import java.util.ArrayList;

import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.TrainDto;

public interface TrainDTO {
	public ArrayList<TrainDto> searchTrains(String a, String b, String c) throws DbException;
}
