package ZpectrumApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CryptoDTO.
 * 
 * @author Francisco González
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoDTO {

	private long id;

	@JsonProperty(value = "name")
	private String cryptoName;

	@JsonProperty(value = "price")
	private double price;

	@JsonProperty(value = "balance")
	private String balance;

	@JsonProperty(value = "marketCap")
	private double marketcap;

	@JsonProperty(value = "valueUsd")
	private double valueUsd;

	@JsonProperty(value = "decimals")
	private int decimals;

	/**
	 * Constructor: Instantiates a new crypto currency DTO.
	 *
	 * @param cryptoName the crypto currency name
	 * @param price      the price of crypto currency
	 * @param balance    the balance of crypto currency
	 * @param marketcap  the marketcap
	 * @param valueUSD   the value USD $
	 */
	public CryptoDTO(String cryptoName, double price, String balance, double marketcap, double valueUSD) {
		super();
		this.cryptoName = cryptoName;
		this.price = price;
		this.balance = balance;
		this.marketcap = marketcap;
		this.valueUsd = valueUSD;
	}

	/**
	 * Constructor: Instantiates a new crypto currency DTO.
	 *
	 * @param cryptoName the crypto currency name
	 * @param price      the price of crypto currency
	 * @param balance    the balance of crypto currency
	 * @param marketcap  the marketcap
	 * @param valueUsd   the value USD $
	 * @param decimals   the decimals
	 */
	public CryptoDTO(String cryptoName, double price, String balance, double marketcap, double valueUsd, int decimals) {
		super();
		this.cryptoName = cryptoName;
		this.price = price;
		this.balance = balance;
		this.marketcap = marketcap;
		this.valueUsd = valueUsd;
		this.decimals = decimals;
	}

	/**
	 * Constructor: Instantiates a new crypto currency DTO.
	 */
	public CryptoDTO() {
		super();
	}

	/**
	 * Gets the value USD $.
	 *
	 * @return the value USD $
	 */
	public double getValueUsd() {
		return valueUsd;
	}

	/**
	 * Sets the value USD $.
	 *
	 * @param valueUsd the new value USD $
	 */
	public void setValueUsd(double valueUsd) {
		this.valueUsd = valueUsd;
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the balance of crypto currency.
	 *
	 * @return the balance of crypto currency
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * Sets the balance of crypto currency.
	 *
	 * @param balance the new balance of crypto currency
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
		return valueUsd;
	}

	/**
	 * Sets the value USD $.
	 *
	 * @param valueUSD the new value USD $
	 */
	public void setValueUSD(double valueUSD) {
		this.valueUsd = valueUSD;
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
	 * @return the price of crypto currency.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CryptoDTO [id=" + id + ", cryptoName=" + cryptoName + ", price=" + price + ", balance=" + balance
				+ ", marketcap=" + marketcap + ", valueUsd=" + valueUsd + ", decimals=" + decimals + "]";
	}

}
