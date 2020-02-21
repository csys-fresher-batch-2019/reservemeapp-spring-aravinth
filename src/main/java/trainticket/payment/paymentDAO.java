package trainticket.payment;

public interface paymentDAO {
	public boolean paymentSuccess(int bookingId);
	public boolean paymentFailure(int bookingId);
	public int totTicPrice(int bookingId);
	public boolean cashPay(int bookingId, String paymentMode);
}
