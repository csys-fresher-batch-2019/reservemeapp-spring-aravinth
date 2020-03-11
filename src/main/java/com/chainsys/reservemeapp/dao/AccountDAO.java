package com.chainsys.reservemeapp.dao;

import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.Account;

public interface AccountDAO {
	public int addUser(Account l) throws DbException;

	public boolean checkEmail(String mail) throws DbException;

	public boolean checkLogin(int userId, String Password) throws DbException;

	public boolean checkId(int userId, String emailId) throws DbException;

	public boolean changePassword(int userId, String newPassword) throws DbException;

	public boolean checkPassword(int userId, String oldPassword) throws DbException;
}
