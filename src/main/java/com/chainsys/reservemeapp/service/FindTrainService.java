package com.chainsys.reservemeapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.FindTrainDAO;
import com.chainsys.reservemeapp.dao.impl.FindTrainImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.FindTrain;

@Service
public class FindTrainService {
	FindTrainDAO obj = new FindTrainImpl();

	public ArrayList<FindTrain> SearchTrain(String a, String b, String c) throws DbException {
		return obj.searchTrains(a, b, c);
	}

}
