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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userName", fetch = FetchType.LAZY)
	private List<Nft> nftList;

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

	public List<Crypto> getCryptoList() {
		return cryptoList;
	}

	public void setCryptoList(List<Crypto> cryptoList) {
		this.cryptoList = cryptoList;
	}

	public List<Nft> getNftList() {
		return nftList;
	}

	public void setNftList(List<Nft> nftList) {
		this.nftList = nftList;
	}

	public Usuario(String userName, String erd, double balance, int shard, List<Crypto> cryptoList, List<Nft> nftList) {
		super();
		this.userName = userName;
		this.erd = erd;
		this.balance = balance;
		this.shard = shard;
		this.cryptoList = cryptoList;
		this.nftList = nftList;
	}

	public Usuario() {
		super();
	}

	@Override
	public String toString() {
		return "Usuario [userId=" + userId + ", userName=" + userName + ", erd=" + erd + ", balance=" + balance
				+ ", shard=" + shard + ", cryptoList=" + cryptoList + ", nftList=" + nftList + "]";
	}

}
