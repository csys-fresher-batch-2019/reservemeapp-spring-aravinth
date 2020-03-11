package com.chainsys.reservemeapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chainsys.reservemeapp.dao.createAccountDAO;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.exception.InfoMessages;
import com.chainsys.reservemeapp.model.createAccount;
import com.chainsys.reservemeapp.util.TestConnection;

public class createAccountIMPL implements createAccountDAO {
	public int AddUser(createAccount l) throws DbException {
		int userId = 0;
		try (Connection con = TestConnection.connect();) {
			String sql = "insert into user_account(user_name,user_id,user_password,gender,dob,contact_number,mail_id) values(?,user_id.nextval,?,?,?,?,?)";
			try (PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setString(1, l.getUserName());
				pst.setString(2, l.getUserPassword());
				pst.setString(3, l.getGender());
				java.sql.Date dob = java.sql.Date.valueOf(l.getDob());
				pst.setDate(4, dob);
				pst.setLong(5, l.getContactNumber());
				pst.setString(6, l.getMailId());
				pst.executeUpdate();
				String mailId = l.getMailId();
				userId = showUserId(mailId);
				System.out.println("Succesfully Account created");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.ADDINGACCOUNT, e);
		}
		return userId;
	}

	private int showUserId(String mailId) throws DbException {

		try (Connection con = TestConnection.connect();) {
			int userid = 0;
			String sql1 = "select user_id from user_account where mail_id = ?";
			try (PreparedStatement pst1 = con.prepareStatement(sql1);) {
				pst1.setString(1, mailId);
				try (ResultSet rows = pst1.executeQuery();) {
					System.out.println(rows);
					if (rows.next()) {
						userid = rows.getInt("user_id");
					}
					return userid;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.ADDINGACCOUNT, e);
		}
	}

	public boolean checkEmail(String mail) throws DbException {
		try (Connection con = TestConnection.connect();) {
			String sql = "select mail_id from user_account where mail_id =?";
			try (PreparedStatement pst1 = con.prepareStatement(sql);) {
				if (pst1.executeUpdate() == 0) {
					return true;
				}

				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.EMAIL_CHECK, e);

		}
	}

	public boolean checkLogin(int userId, String Password) throws DbException {
		boolean res = false;
		try (Connection con = TestConnection.connect();) {
			String sql = "select user_id,user_password from user_account where user_id = ?and user_password=?";
			try (PreparedStatement pst1 = con.prepareStatement(sql);) {
				pst1.setInt(1, userId);
				pst1.setString(2, Password);
				try (ResultSet rows = pst1.executeQuery();) {
					if (rows.next()) {
						res = true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.LOGIN, e);
		}
		return res;
	}

	public boolean checkId(int userId, String emailId) throws DbException {
		boolean res = false;
		try (Connection con = TestConnection.connect();) {
			String sql = "select user_id,mail_id from user_account where user_id = ? and mail_id=?";
			try (PreparedStatement pst1 = con.prepareStatement(sql);) {
				pst1.setInt(1, userId);
				pst1.setString(2, emailId);
				try (ResultSet rows = pst1.executeQuery();) {
					if (rows.next()) {
						res = true;
					} else {
						return false;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CHECKDATA, e);
		}
		return res;
	}

	public boolean changePassword(int userId, String newPassword) throws DbException {
		try (Connection con = TestConnection.connect();) {
			String sql = "update user_account set user_password=? where user_id =?";
			try (PreparedStatement pst1 = con.prepareStatement(sql);) {
				pst1.setString(1, newPassword);
				pst1.setInt(2, userId);
				pst1.executeUpdate();
				System.out.println("Password changed succecfully");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.PASSWORD_CHANGE, e);

		}
	}

	public boolean checkPassword(int userId, String oldPassword) throws DbException {
		try (Connection con = TestConnection.connect();) {
			String sql = "select user_id,user_password from user_account where user_id =?and user_password=?";
			try (PreparedStatement pst1 = con.prepareStatement(sql);) {
				pst1.setInt(1, userId);
				pst1.setString(2, oldPassword);
				if (pst1.executeUpdate() == 1) {
					return true;
				} else {
					System.out.println("Invalid User id or password");
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CHECK_PASSWORD, e);

		}
	}

}