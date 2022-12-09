package ZpectrumApp.Modelo;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.stereotype.Component;

/**
 * The Class Usuario.
 * 
 * @author Francisco González
 * @version 1.0
 */
@Component
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "erd" }) })
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(name = "userName")
	private String userName;

	@Column(name = "erd")
	private String erd;

	@Column(name = "balance")
	private double balance;

	@Column(name = "shard")
	private int shard;

	@OneToMany(cascade = CascadeType.ALL,  mappedBy = "owner", fetch = FetchType.LAZY)
	private List<Crypto> cryptoList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userName", fetch = FetchType.EAGER)
	private List<Nft> nftList;

	/**
	 * Constructor: Instantiates a new user.
	 *
	 * @param userName the user name
	 * @param erd the ERD
	 * @param balance the balance
	 * @param shard the shard
	 * @param cryptoList the crypto currency list
	 * @param nftList the NFT list
	 */
	public Usuario(String userName, String erd, double balance, int shard, List<Crypto> cryptoList, List<Nft> nftList) {
		super();
		this.userName = userName;
		this.erd = erd;
		this.balance = balance;
		this.shard = shard;
		this.cryptoList = cryptoList;
		this.nftList = nftList;
	}

	/**
	 * Constructor: Instantiates a new usuario.
	 */
	public Usuario() {
		super();
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
	 * Gets the crypto currency list.
	 *
	 * @return the crypto currency list
	 */
	public List<Crypto> getCryptoList() {
		return cryptoList;
	}

	/**
	 * Sets the crypto currency list.
	 *
	 * @param cryptoList the new crypto currency list
	 */
	public void setCryptoList(List<Crypto> cryptoList) {
		this.cryptoList = cryptoList;
	}

	/**
	 * Gets the NFT list.
	 *
	 * @return the NFT list
	 */
	public List<Nft> getNftList() {
		return nftList;
	}

	/**
	 * Sets the NFT list.
	 *
	 * @param nftList the new NFT list
	 */
	public void setNftList(List<Nft> nftList) {
		this.nftList = nftList;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Usuario [userId=" + userId + ", userName=" + userName + ", erd=" + erd + ", balance=" + balance
				+ ", shard=" + shard + ", cryptoList=" + cryptoList + ", nftList=" + nftList + "]";
	}

}
