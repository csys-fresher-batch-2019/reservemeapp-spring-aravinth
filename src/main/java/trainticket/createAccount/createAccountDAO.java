package trainticket.createAccount;

import trainticket.Exception.DbException;

public interface createAccountDAO {
	public int AddUser(createAccount l) throws DbException;
	public boolean checkEmail(String mail) throws DbException;
	public boolean checkLogin(int userId,String Password) throws DbException;
    public boolean checkId(int userId,String emailId) throws DbException;
    public boolean changePassword(int userId,String a1) throws DbException;
    public boolean checkPassword(int userId,String oldPassword)throws DbException;
}
