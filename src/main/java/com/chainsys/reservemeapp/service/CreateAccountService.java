package com.chainsys.reservemeapp.service;

import org.springframework.stereotype.Service;

import com.chainsys.reservemeapp.dao.createAccountDAO;
import com.chainsys.reservemeapp.dao.impl.createAccountIMPL;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.createAccount;

@Service
public class CreateAccountService {
	createAccountDAO obj = new createAccountIMPL();
	public int AddUser(createAccount l) throws DbException {
		return obj.AddUser(l);
	}
	public boolean checkEmail(String mail) throws DbException {
		return false;
	}
	public boolean checkLogin(int userId,String Password) throws DbException {
		return false;
	}
    public boolean checkId(int userId,String emailId) throws DbException {
		return false;
	}
    public boolean changePassword(int userId,String a1) throws DbException {
		return false;
	}
    public boolean checkPassword(int userId,String oldPassword)throws DbException {
		return false;
	}


}
