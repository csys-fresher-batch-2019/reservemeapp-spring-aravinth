package com.chainsys.reservemeapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.TrainsDAO;
import com.chainsys.reservemeapp.dao.impl.TrainsDAOImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.ServiceException;
import com.chainsys.reservemeapp.model.Trains;
import com.chainsys.reservemeapp.util.InfoMessages;

@Service
public class TrainsService {
	private TrainsDAO obj = new TrainsDAOImpl();

	public void addTrains(Trains l) throws ServiceException {
		try {
			obj.addTrain(l);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.TRAIN_INSERTION, e);

		}
	}

	public void removeTrain(int trainNum) throws ServiceException {
		try {
			obj.removeTrain(trainNum);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.DELETE_TRAINS,e);
			
		}
	}

	public List<String> getSourceStation() throws ServiceException {
		try {
			return obj.getSourceStation();
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.SOURCE,e);
		}
	}

	public List<String> getDestinationStation() throws ServiceException {
		try {
			return obj.getDestinationStation();
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.DESTINATION,e);
		}
	}

}
