package com.chainsys.reservemeapp.dao;

import com.chainsys.reservemeapp.exception.DbException;

public interface PaymentDAO {
	public boolean paymentMethod(int bookingId, String PaySts, String paymentMode) throws DbException;

	public int totTicketPrice(int bookingId) throws DbException;

}
