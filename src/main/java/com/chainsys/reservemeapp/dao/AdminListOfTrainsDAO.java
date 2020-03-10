package com.chainsys.reservemeapp.dao;

import java.util.List;

import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.AdminListOfTrains;

public interface AdminListOfTrainsDAO {

	public void addTrains(AdminListOfTrains l) throws DbException;

	public void removeTrain(int trainNum) throws DbException;

	public void updateTimings(int train_num, String TravellingTime) throws DbException;

	public List<String> getSourceStation() throws DbException;

	public List<String> getDestinationStation() throws DbException;
}
