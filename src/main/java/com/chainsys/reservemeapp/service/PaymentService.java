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

	public boolean paymentMethod(int bookingId, String PaySts, String PaymentMode) throws ServiceException {
		try {
			return obj.paymentMethod(bookingId, PaySts, PaymentMode);
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

}
