package com.chainsys.reservemeapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.AdminListOfTrainsDAO;
import com.chainsys.reservemeapp.dao.impl.AdminListOfTrainsImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.AdminListOfTrains;

@Service
public class AdminListOfTrainsService {
	private AdminListOfTrainsDAO obj = new AdminListOfTrainsImpl();

	public void addTrains(AdminListOfTrains l) throws DbException {
		obj.addTrains(l);
	}

	public void removeTrain(int trainNum) throws DbException {
		obj.removeTrain(trainNum);
	}

	public void updateTimings(int train_num, String TravellingTime) throws DbException {
		obj.updateTimings(train_num, TravellingTime);
	}

	public List<String> getSourceStation() throws DbException {
		return obj.getSourceStation();
	}

	public List<String> getDestinationStation() throws DbException {
		return obj.getDestinationStation();
	}

}
