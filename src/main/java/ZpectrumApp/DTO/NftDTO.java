package ZpectrumApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	public long getNftId() {
		return nftId;
	}

	public String getNftName() {
		return nftName;
	}

	public void setNftName(String nftName) {
		this.nftName = nftName;
	}

	public String getColletionName() {
		return colletionName;
	}

	public void setColletionName(String colletionName) {
		this.colletionName = colletionName;
	}

	public int getRoyalties() {
		return royalties;
	}

	public void setRoyalties(int royalties) {
		this.royalties = royalties;
	}

	public String getNftUrl() {
		return nftUrl;
	}

	public void setNftUrl(String nftUrl) {
		this.nftUrl = nftUrl;
	}

	public NftDTO(long nftId, String nftName, String colletionName, int royalties, String nftUrl) {
		super();
		this.nftId = nftId;
		this.nftName = nftName;
		this.colletionName = colletionName;
		this.royalties = royalties;
		this.nftUrl = nftUrl;
	}

	public NftDTO() {
		super();
	}

	@Override
	public String toString() {
		return "NftDTO [nftId=" + nftId + ", nftName=" + nftName + ", colletionName=" + colletionName + ", royalties="
				+ royalties + ", nftUrl=" + nftUrl + "]";
	}

}
