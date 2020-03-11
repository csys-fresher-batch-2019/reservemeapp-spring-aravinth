package com.chainsys.reservemeapp.dao;

import java.util.List;

import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.Trains;

public interface TrainsDAO {

	public void addTrain(Trains l) throws DbException;

	public void removeTrain(int trainNum) throws DbException;

	public List<String> getSourceStation() throws DbException;

	public List<String> getDestinationStation() throws DbException;
}
