package com.chainsys.reservemeapp.payment;

import com.chainsys.reservemeapp.exception.DbException;

public interface paymentDAO {
	public boolean paymentSuccess(int bookingId) throws DbException;
	public boolean paymentFailure(int bookingId) throws DbException;
	public int totTicPrice(int bookingId) throws DbException;
	public boolean cashPay(int bookingId, String paymentMode)throws DbException;
}
