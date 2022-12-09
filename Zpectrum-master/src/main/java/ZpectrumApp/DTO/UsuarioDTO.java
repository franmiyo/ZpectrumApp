package ZpectrumApp.DTO;

/**
 * The Class UsuarioDTO.
 * 
 * @author Francisco González
 * @version 1.0
 */
public class UsuarioDTO {

	/** The user id. */
	private long userId;
	
	/** The user name. */
	private String userName;
	
	/** The ERD. */
	private String erd;
	
	/** The balance. */
	private double balance;
	
	/** The shard. */
	private int shard;

	/**
	 * Constructor: Instantiates a new user DTO.
	 *
	 * @param userId the user id
	 * @param userName the user name
	 * @param erd the ERD
	 * @param balance the balance
	 * @param shard the shard
	 */
	public UsuarioDTO(long userId, String userName, String erd, double balance, int shard) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.erd = erd;
		this.balance = balance;
		this.shard = shard;
	}

	/**
	 * Constructor: Instantiates a new user DTO.
	 */
	public UsuarioDTO() {
		super();
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the ERD.
	 *
	 * @return the ERD
	 */
	public String getErd() {
		return erd;
	}

	/**
	 * Sets the ERD.
	 *
	 * @param erd the new ERD
	 */
	public void setErd(String erd) {
		this.erd = erd;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Gets the shard.
	 *
	 * @return the shard
	 */
	public int getShard() {
		return shard;
	}

	/**
	 * Sets the shard.
	 *
	 * @param shard the new shard
	 */
	public void setShard(int shard) {
		this.shard = shard;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UsuarioDTO [userId=" + userId + ", userName=" + userName + ", erd=" + erd + ", balance=" + balance
				+ ", shard=" + shard + "]";
	}

}
