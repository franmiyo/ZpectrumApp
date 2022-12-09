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

/**
 * The Class Crypto.
 * 
 * @author Francisco González
 * @version 1.0
 */
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

	/**
	 * Constructor: Instantiates a new crypto currency.
	 *
	 * @param cryptoId the crypto currency id
	 * @param cryptoName the crypto currency name
	 * @param balance the balance
	 * @param marketcap the marketcap
	 * @param valueUSD the value USD $
	 * @param price the price of crypto currency
	 * @param owner the owner of crypto currency
	 */
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

	/**
	 * Constructor: Instantiates a new crypto currency.
	 *
	 * @param cryptoId the crypto currency id
	 * @param cryptoName the crypto currency name
	 * @param balance the balance
	 * @param marketcap the marketcap
	 * @param valueUSD the value USD $
	 * @param price the price of crypto currency
	 * @param decimals the decimals
	 * @param owner the owner of crypto currency
	 */
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

	/**
	 * Constructor: Instantiates a new crypto currency.
	 */
	public Crypto() {
		super();
	}

	/**
	 * Gets the decimals.
	 *
	 * @return the decimals
	 */
	public int getDecimals() {
		return decimals;
	}

	/**
	 * Sets the decimals.
	 *
	 * @param decimals the new decimals
	 */
	public void setDecimals(int decimals) {
		this.decimals = decimals;
	}

	/**
	 * Gets the crypto currency id.
	 *
	 * @return the crypto currency id
	 */
	public long getCryptoId() {
		return cryptoId;
	}

	/**
	 * Gets the crypto currency name.
	 *
	 * @return the crypto currency name
	 */
	public String getCryptoName() {
		return cryptoName;
	}

	/**
	 * Sets the crypto currency name.
	 *
	 * @param cryptoName the new crypto currency name
	 */
	public void setCryptoName(String cryptoName) {
		this.cryptoName = cryptoName;
	}

	/**
	 * Gets the price of crypto currency.
	 *
	 * @return the price of crypto currency
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of crypto currency.
	 *
	 * @param price the new price of crypto currency
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the owner of crypto currency.
	 *
	 * @return the owner of crypto currency
	 */
	public Usuario getOwner() {
		return owner;
	}

	/**
	 * Sets the owner of crypto currency.
	 *
	 * @param owner the new owner of crypto currency
	 */
	public void setOwner(Usuario owner) {
		this.owner = owner;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}

	/**
	 * Gets the marketcap.
	 *
	 * @return the marketcap
	 */
	public double getMarketcap() {
		return marketcap;
	}

	/**
	 * Sets the marketcap.
	 *
	 * @param marketcap the new marketcap
	 */
	public void setMarketcap(double marketcap) {
		this.marketcap = marketcap;
	}

	/**
	 * Gets the value USD $.
	 *
	 * @return the value USD $
	 */
	public double getValueUSD() {
		return valueUSD;
	}

	/**
	 * Sets the value USD $.
	 *
	 * @param valueUSD the new value USD $
	 */
	public void setValueUSD(double valueUSD) {
		this.valueUSD = valueUSD;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Crypto [cryptoId=" + cryptoId + ", cryptoName=" + cryptoName + ", balance=" + balance + ", marketcap="
				+ marketcap + ", valueUSD=" + valueUSD + ", price=" + price + ", owner=" + owner + "]";
	}

}
