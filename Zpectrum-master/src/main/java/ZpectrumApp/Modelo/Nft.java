package ZpectrumApp.Modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * The Class Nft.
 * 
 * @author Francisco González
 * @version 1.0
 */
@Component
@Entity
@Table(name = "nft")
public class Nft {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nftId;

	@Column(name = "nftName")
	private String nftName;

	@Column(name = "colletionName")
	private String colletionName;

	@Column(name = "royalties")
	private int royalties;

	@Column(name = "nftUrl")
	private String nftUrl;

	@Lob
	@Column(name = "nftImage")
	private byte[] nftImage;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Usuario userName;

	/**
	 * Constructor: Instantiates a new NFT.
	 *
	 * @param nftId         the NFT id
	 * @param nftName       the NFT name
	 * @param colletionName the collection name
	 * @param royalties     the royalties of NFT
	 * @param nftUrl        the NFT url
	 * @param userName      the user name
	 */
	public Nft(long nftId, String nftName, String colletionName, int royalties, String nftUrl, Usuario userName) {
		super();
		this.nftId = nftId;
		this.nftName = nftName;
		this.colletionName = colletionName;
		this.royalties = royalties;
		this.nftUrl = nftUrl;
		this.userName = userName;
	}

	/**
	 * Constructor: Instantiates a new NFT.
	 */
	public Nft() {
		super();
	}

	/**
	 * Gets the NFT image.
	 *
	 * @return the NFT image
	 */
	public byte[] getNftImage() {
		return nftImage;
	}

	/**
	 * Sets the NFT image.
	 *
	 * @param nftImage the new NFT image
	 */
	public void setNftImage(byte[] nftImage) {
		this.nftImage = nftImage;
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
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public Usuario getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(Usuario userName) {
		this.userName = userName;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Nft [nftId=" + nftId + ", nftName=" + nftName + ", colletionName=" + colletionName + ", royalties="
				+ royalties + ", nftUrl=" + nftUrl + ", userName=" + userName + "]";
	}

}
