package trainticket.createAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import trainticket.AdminRole.TestListTrains;

public class createAccountIMPL implements createAccountDAO {
	public int AddUser(createAccount l) {

		try (Connection con = TestListTrains.connect();) {
			int userid = 0;
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
				System.out.println("Succesfully Account created");

				String sql1 = "select user_id from user_account where mail_id = ?";
				try(PreparedStatement pst1 = con.prepareStatement(sql1);){
				pst1.setString(1, l.getMailId());
				try(ResultSet rows = pst1.executeQuery();){
				System.out.println(rows);
				if (rows.next()) {
					userid = rows.getInt("user_id");
				}
				return userid;
			}}}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean checkEmail(String mail) {
		try (Connection con = TestListTrains.connect(); Statement stmt = con.createStatement();) {
			if (stmt.executeUpdate("select mail_id from user_account where mail_id = '" + mail + "'") == 0) {
				return true;
			}

			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean checkLogin(int userId, String Password) {
		try (Connection con = TestListTrains.connect(); Statement stmt = con.createStatement();) {
			if (stmt.executeUpdate("select user_id from user_account where user_id = " + userId) != 0) {
				String sql = "select user_password from user_account where user_id = " + userId;
				try (ResultSet rows = stmt.executeQuery(sql);) {
					if (rows.next()) {
						String userPass = rows.getString("user_password");
						if (userPass.equals(Password)) {
							return true;
						} else {
							return false;
						}
					}

				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean checkId(int userId, String emailId) {
		try (Connection con = TestListTrains.connect(); Statement stmt = con.createStatement();) {
			if (stmt.executeUpdate("select user_id from user_account where user_id =" + userId) == 1) {
				String sql = "select mail_id from user_account where user_id =" + userId;
				try (ResultSet row = stmt.executeQuery(sql);) {
					if (row.next()) {
						String mail = row.getString("mail_id");
						if (mail.equals(emailId)) {
							return true;
						}
					}

				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean changePassword(int userId, String a1) {
		try (Connection con = TestListTrains.connect(); Statement stmt = con.createStatement();) {
			String sql = "update user_account set user_password='" + a1 + "' where user_id =" + userId;
			stmt.executeUpdate(sql);
			System.out.println("Password changed succecfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean checkPassword(int userId, String oldPassword) {
		try (Connection con = TestListTrains.connect(); Statement stmt = con.createStatement();) {
			if (stmt.executeUpdate("select user_id,user_password from user_account where user_id ='" + userId
					+ "' and user_password='" + oldPassword + "'") == 1) {
				return true;
			} else {
				System.out.println("Invalid User id or password");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}