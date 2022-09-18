package ZpectrumApp.DTO;

public class UsuarioDTO {

	private long userId;
	private String userName;
	private String erd;
	private double balance;
	private int shard;

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getErd() {
		return erd;
	}

	public void setErd(String erd) {
		this.erd = erd;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getShard() {
		return shard;
	}

	public void setShard(int shard) {
		this.shard = shard;
	}

	public UsuarioDTO(long userId, String userName, String erd, double balance, int shard) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.erd = erd;
		this.balance = balance;
		this.shard = shard;
	}

	public UsuarioDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UsuarioDTO [userId=" + userId + ", userName=" + userName + ", erd=" + erd + ", balance=" + balance
				+ ", shard=" + shard + "]";
	}

}
