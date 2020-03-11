package com.chainsys.reservemeapp.dao;

import com.chainsys.reservemeapp.exception.DbException;

public interface SeatStatusDAO {
	public void updatingSeats(int trainNum) throws DbException;

	public int availableSeats(int trainNum) throws DbException;
}
