package com.chainsys.reservemeapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.AccountDAO;
import com.chainsys.reservemeapp.dao.impl.AccountDAOImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.ServiceException;
import com.chainsys.reservemeapp.model.Account;
import com.chainsys.reservemeapp.util.InfoMessages;

@Service
public class AccountService {
	AccountDAO obj = new AccountDAOImpl();

	public int AddUser(Account l) throws ServiceException {
		try {
			return obj.addUser(l);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.ADDINGACCOUNT,e);
		}
	}

	public boolean checkEmail(String mail) throws ServiceException {
		try {
			return obj.checkEmail(mail);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.EMAIL_CHECK, e);
		}
	}

	public boolean checkLogin(int userId, String Password) throws ServiceException {
		try {
			return obj.checkLogin(userId, Password);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.LOGIN, e);
		}
	}

	public boolean checkId(int userId, String emailId) throws ServiceException {
		try {
			return obj.checkId(userId, emailId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.CHECKDATA, e);
		}
	}

	public boolean changePassword(int userId, String newPassword) throws ServiceException {
		try {
			return obj.changePassword(userId, newPassword);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.PASSWORD_CHANGE, e);
		}
	}

	public boolean checkPassword(int userId, String oldPassword) throws ServiceException {
		try {
			return obj.checkPassword(userId, oldPassword);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(InfoMessages.CHECK_PASSWORD, e);
		}
	}

}
