package com.chainsys.reservemeapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			} catch (Exception e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.ADDINGACCOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
		return userId;
	}

	public int showUserId(String mailId) throws DbException {

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
			} catch (Exception e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.ADDINGACCOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
	}

	public boolean checkEmail(String mail) throws DbException {
		try (Connection con = TestConnection.connect(); Statement stmt = con.createStatement();) {
			if (stmt.executeUpdate("select mail_id from user_account where mail_id = '" + mail + "'") == 0) {
				return true;
			}

			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);

		}
	}

	public boolean checkLogin(int userId, String Password) throws DbException {
		boolean res = false;
		try (Connection con = TestConnection.connect(); Statement stmt = con.createStatement();) {
			String sql = "select user_id,user_password from user_account where user_id = " + userId+ " and user_password='" + Password+"'";
			try (ResultSet rows = stmt.executeQuery(sql);) {
				if (rows.next()) {
					res = true;
				} 
			} catch (Exception e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.LOGIN);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
		return res;
	}

	public boolean checkId(int userId, String emailId) throws DbException {
		boolean res = false;
		try (Connection con = TestConnection.connect(); Statement stmt = con.createStatement();) {
			String sql = "select user_id,mail_id from user_account where user_id = " + userId + " and mail_id='"
					+ emailId+"'";
			try (ResultSet rows = stmt.executeQuery(sql);) {
				if (rows.next()) {
					res = true;
				} else {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new DbException(InfoMessages.LOGIN);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);
		}
		return res;
	}

	public boolean changePassword(int userId, String newPassword) throws DbException {
		try (Connection con = TestConnection.connect(); Statement stmt = con.createStatement();) {
			String sql = "update user_account set user_password='" + newPassword + "' where user_id =" + userId;
			stmt.executeUpdate(sql);
			System.out.println("Password changed succecfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);

		}
	}

	public boolean checkPassword(int userId, String oldPassword) throws DbException {
		try (Connection con = TestConnection.connect(); Statement stmt = con.createStatement();) {
			if (stmt.executeUpdate("select user_id,user_password from user_account where user_id ='" + userId
					+ "' and user_password='" + oldPassword + "'") == 1) {
				return true;
			} else {
				System.out.println("Invalid User id or password");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION);

		}
	}

}