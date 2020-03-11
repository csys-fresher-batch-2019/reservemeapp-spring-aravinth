package com.chainsys.reservemeapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.PaymentDAO;
import com.chainsys.reservemeapp.dao.impl.PaymentDAOImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.ServiceException;
import com.chainsys.reservemeapp.util.InfoMessages;

@Service
public class PaymentService {
	PaymentDAO obj = new PaymentDAOImpl();

	public boolean paymentSuccess(int bookingId,String PaySts,String PaymentMode) throws ServiceException {
		try {
			return obj.paymentSuccess(bookingId,PaySts,PaymentMode);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.UPDATE_PAYMENT, e);
		}
	}

	public boolean paymentFailure(int bookingId) throws ServiceException {
		try {
			return obj.paymentFailure(bookingId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.UPDATE_PAYMENT, e);
		}
	}

	public int totTicPrice(int bookingId) throws ServiceException {
		try {
			return obj.totTicketPrice(bookingId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.PRICE, e);
		}
	}

	public boolean cashPay(int bookingId, String paymentMode,String paymentStatus) throws ServiceException {
		try {
			return obj.cashPay(bookingId, paymentMode,paymentStatus);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.UPDATE_PAYMENT, e);
		}
	}

}
