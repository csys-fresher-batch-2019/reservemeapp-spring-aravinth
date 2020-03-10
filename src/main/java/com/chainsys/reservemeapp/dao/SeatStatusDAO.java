package com.chainsys.reservemeapp.dao;

import com.chainsys.reservemeapp.exception.DbException;

public interface SeatStatusDAO {
	public void updatingSeats(int trainNum) throws DbException;

	public int AvailSeats(int trainNum) throws DbException;
}
