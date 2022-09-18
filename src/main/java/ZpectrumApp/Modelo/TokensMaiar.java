package ZpectrumApp.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokensMaiar {

	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "price")
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public TokensMaiar(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public TokensMaiar() {
		super();
	}

	@Override
	public String toString() {
		return "TokensMaiar [name=" + name + ", price=" + price + "]";
	}

}
