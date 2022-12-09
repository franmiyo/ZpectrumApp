package ZpectrumApp.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class TokensMaiar.
 * 
 * @author Francisco González
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokensMaiar {

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "price")
	private double price;

	/**
	 * Constructor: Instantiates a new tokens maiar.
	 *
	 * @param name the name
	 * @param price the price
	 */
	public TokensMaiar(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	/**
	 * Constructor: Instantiates a new tokens maiar.
	 */
	public TokensMaiar() {
		super();
	}

	/**
	 * Gets the name of token.
	 *
	 * @return the name of token
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of token.
	 *
	 * @param name the new name of token
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the price of token.
	 *
	 * @return the price of token
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of token.
	 *
	 * @param price the new price of token
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
		return "TokensMaiar [name=" + name + ", price=" + price + "]";
	}

}
