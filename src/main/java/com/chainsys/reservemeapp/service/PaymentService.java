package com.chainsys.reservemeapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.PaymentDAO;
import com.chainsys.reservemeapp.dao.impl.PaymentImpl;
import com.chainsys.reservemeapp.exception.DbException;

@Service
public class PaymentService {
	PaymentDAO obj = new PaymentImpl();

	public boolean paymentSuccess(int bookingId) throws DbException {
		return obj.paymentSuccess(bookingId);
	}

	public boolean paymentFailure(int bookingId) throws DbException {
		return obj.paymentFailure(bookingId);
	}

	public int totTicPrice(int bookingId) throws DbException {
		return obj.totTicketPrice(bookingId);
	}

	public boolean cashPay(int bookingId, String paymentMode) throws DbException {
		return obj.cashPay(bookingId, paymentMode);
	}

}
