package com.chainsys.reservemeapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.findTrainDAO;
import com.chainsys.reservemeapp.dao.impl.findTrainIMPL;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.findTrain;

@Service
public class FindTrainService {
	findTrainDAO obj = new findTrainIMPL();
	public ArrayList<findTrain>SearchTrain(String a,String b,String c) throws DbException {
		return obj.SearchTrain(a, b, c);
	}

	

}
