package com.chainsys.reservemeapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.CreateAccountDAO;
import com.chainsys.reservemeapp.dao.impl.CreateAccountImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.CreateAccount;

@Service
public class CreateAccountService {
	CreateAccountDAO obj = new CreateAccountImpl();

	public int AddUser(CreateAccount l) throws DbException {
		return obj.addUser(l);
	}

	public boolean checkEmail(String mail) throws DbException {
		return obj.checkEmail(mail);
	}

	public boolean checkLogin(int userId, String Password) throws DbException {
		return obj.checkLogin(userId, Password);
	}

	public boolean checkId(int userId, String emailId) throws DbException {
		return obj.checkId(userId, emailId);
	}

	public boolean changePassword(int userId, String a1) throws DbException {
		return obj.changePassword(userId, a1);
	}

	public boolean checkPassword(int userId, String oldPassword) throws DbException {
		return obj.checkPassword(userId, oldPassword);
	}

}
