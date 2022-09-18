package ZpectrumApp.Modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "crypto")
public class Crypto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cryptoId;

	@Column(name = "cryptoName")
	private String cryptoName;

	@Column(name = "balance")
	private String balance;

	@Column(name = "marketcap")
	private double marketcap;

	@Column(name = "valueUSD")
	private double valueUSD;

	@Column(name = "price")
	private double price;

	@Column(name = "decimals")
	private int decimals;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Usuario owner;

	public int getDecimals() {
		return decimals;
	}

	public void setDecimals(int decimals) {
		this.decimals = decimals;
	}

	public long getCryptoId() {
		return cryptoId;
	}

	public String getCryptoName() {
		return cryptoName;
	}

	public void setCryptoName(String cryptoName) {
		this.cryptoName = cryptoName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Usuario getOwner() {
		return owner;
	}

	public void setOwner(Usuario owner) {
		this.owner = owner;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public double getMarketcap() {
		return marketcap;
	}

	public void setMarketcap(double marketcap) {
		this.marketcap = marketcap;
	}

	public double getValueUSD() {
		return valueUSD;
	}

	public void setValueUSD(double valueUSD) {
		this.valueUSD = valueUSD;
	}

	public Crypto(long cryptoId, String cryptoName, String balance, double marketcap, double valueUSD, double price,
			Usuario owner) {
		super();
		this.cryptoId = cryptoId;
		this.cryptoName = cryptoName;
		this.balance = balance;
		this.marketcap = marketcap;
		this.valueUSD = valueUSD;
		this.price = price;
		this.owner = owner;
	}

	
	public Crypto(long cryptoId, String cryptoName, String balance, double marketcap, double valueUSD, double price,
			int decimals, Usuario owner) {
		super();
		this.cryptoId = cryptoId;
		this.cryptoName = cryptoName;
		this.balance = balance;
		this.marketcap = marketcap;
		this.valueUSD = valueUSD;
		this.price = price;
		this.decimals = decimals;
		this.owner = owner;
	}

	public Crypto() {
		super();
	}

	@Override
	public String toString() {
		return "Crypto [cryptoId=" + cryptoId + ", cryptoName=" + cryptoName + ", balance=" + balance + ", marketcap="
				+ marketcap + ", valueUSD=" + valueUSD + ", price=" + price + ", owner=" + owner + "]";
	}

}
