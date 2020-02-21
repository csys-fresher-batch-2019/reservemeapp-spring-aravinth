package trainticket.createAccount;

public interface createAccountDAO {
	public int AddUser(createAccount l);
	public boolean checkEmail(String mail);
	public boolean checkLogin(int userId,String Password);
    public boolean checkId(int userId,String emailId);
    public boolean changePassword(int userId,String a1);
    public boolean checkPassword(int userId,String oldPassword);
}
