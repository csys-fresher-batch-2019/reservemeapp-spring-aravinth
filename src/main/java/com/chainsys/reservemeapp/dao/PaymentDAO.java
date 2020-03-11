package com.chainsys.reservemeapp.dao;

import com.chainsys.reservemeapp.exception.DbException;

public interface PaymentDAO {
	public boolean paymentSuccess(int bookingId) throws DbException;

	public boolean paymentFailure(int bookingId) throws DbException;

	public int totTicketPrice(int bookingId) throws DbException;

	public boolean cashPay(int bookingId, String paymentMode) throws DbException;
}
