package ZpectrumApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty (value ="decimals")
	private int decimals;

	public double getValueUsd() {
		return valueUsd;
	}

	public void setValueUsd(double valueUsd) {
		this.valueUsd = valueUsd;
	}

	public int getDecimals() {
		return decimals;
	}

	public void setDecimals(int decimals) {
		this.decimals = decimals;
	}

	public long getId() {
		return id;
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
		return valueUsd;
	}

	public void setValueUSD(double valueUSD) {
		this.valueUsd = valueUSD;
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

	public CryptoDTO(String cryptoName, double price, String balance, double marketcap, double valueUSD) {
		super();
		this.cryptoName = cryptoName;
		this.price = price;
		this.balance = balance;
		this.marketcap = marketcap;
		this.valueUsd = valueUSD;
	}
	
	public CryptoDTO(String cryptoName, double price, String balance, double marketcap, double valueUsd, int decimals) {
		super();
		this.cryptoName = cryptoName;
		this.price = price;
		this.balance = balance;
		this.marketcap = marketcap;
		this.valueUsd = valueUsd;
		this.decimals = decimals;
	}

	public CryptoDTO() {
		super();
	}

	@Override
	public String toString() {
		return "CryptoDTO [id=" + id + ", cryptoName=" + cryptoName + ", price=" + price + ", balance=" + balance
				+ ", marketcap=" + marketcap + ", valueUsd=" + valueUsd + ", decimals=" + decimals + "]";
	}



}
