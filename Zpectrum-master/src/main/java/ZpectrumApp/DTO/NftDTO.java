package ZpectrumApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class NftDTO.
 * 
 * @author Francisco González
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NftDTO {

	private long nftId;
	
	@JsonProperty(value = "name")
	private String nftName;

	@JsonProperty(value = "collection")
	private String colletionName;

	@JsonProperty(value = "royalties")
	private int royalties;

	@JsonProperty(value = "url")
	private String nftUrl;
	
	/**
	 * Constructor: Instantiates a new NFT DTO.
	 *
	 * @param nftId         the NFT id
	 * @param nftName       the NFT name
	 * @param colletionName the collection name
	 * @param royalties     the royalties of NFT
	 * @param nftUrl        the NFT url
	 */
	public NftDTO(long nftId, String nftName, String colletionName, int royalties, String nftUrl) {
		super();
		this.nftId = nftId;
		this.nftName = nftName;
		this.colletionName = colletionName;
		this.royalties = royalties;
		this.nftUrl = nftUrl;
	}

	/**
	 * Constructor: Instantiates a new NFT DTO.
	 */
	public NftDTO() {
		super();
	}

	/**
	 * Gets the NFT id.
	 *
	 * @return the NFT id
	 */
	public long getNftId() {
		return nftId;
	}

	/**
	 * Gets the NFT name.
	 *
	 * @return the NFT name
	 */
	public String getNftName() {
		return nftName;
	}

	/**
	 * Sets the NFT name.
	 *
	 * @param nftName the new NFT name
	 */
	public void setNftName(String nftName) {
		this.nftName = nftName;
	}

	/**
	 * Gets the collection name.
	 *
	 * @return the collection name
	 */
	public String getColletionName() {
		return colletionName;
	}

	/**
	 * Sets the collection name.
	 *
	 * @param colletionName the new collection name
	 */
	public void setColletionName(String colletionName) {
		this.colletionName = colletionName;
	}

	/**
	 * Gets the royalties of NFT.
	 *
	 * @return the royalties of NFT
	 */
	public int getRoyalties() {
		return royalties;
	}

	/**
	 * Sets the royalties of NFT.
	 *
	 * @param royalties the new royalties of NFT
	 */
	public void setRoyalties(int royalties) {
		this.royalties = royalties;
	}

	/**
	 * Gets the NFT url.
	 *
	 * @return the NFT url
	 */
	public String getNftUrl() {
		return nftUrl;
	}

	/**
	 * Sets the NFT url.
	 *
	 * @param nftUrl the new NFT url
	 */
	public void setNftUrl(String nftUrl) {
		this.nftUrl = nftUrl;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "NftDTO [nftId=" + nftId + ", nftName=" + nftName + ", colletionName=" + colletionName + ", royalties="
				+ royalties + ", nftUrl=" + nftUrl + "]";
	}

}
