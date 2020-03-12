package com.chainsys.reservemeapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.TrainDTO;
import com.chainsys.reservemeapp.dao.impl.TrainDTOImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.ServiceException;
import com.chainsys.reservemeapp.model.TrainDto;
import com.chainsys.reservemeapp.util.InfoMessages;

@Service
public class TrainDtoService {
	TrainDTO obj = new TrainDTOImpl();

	public ArrayList<TrainDto> SearchTrain(String sourceStation, String destinationStation, String journeyDate) throws ServiceException {
		try {
			return obj.searchTrains(sourceStation, destinationStation, journeyDate);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.FINDTRAIN, e);
		}
	}

}
