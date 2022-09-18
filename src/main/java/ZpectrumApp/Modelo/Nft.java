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

	public byte[] getNftImage() {
		return nftImage;
	}

	public void setNftImage(byte[] nftImage) {
		this.nftImage = nftImage;
	}

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

	public Usuario getUserName() {
		return userName;
	}

	public void setUserName(Usuario userName) {
		this.userName = userName;
	}

	public Nft(long nftId, String nftName, String colletionName, int royalties, String nftUrl, Usuario userName) {
		super();
		this.nftId = nftId;
		this.nftName = nftName;
		this.colletionName = colletionName;
		this.royalties = royalties;
		this.nftUrl = nftUrl;
		this.userName = userName;
	}

	public Nft() {
		super();
	}

	@Override
	public String toString() {
		return "Nft [nftId=" + nftId + ", nftName=" + nftName + ", colletionName=" + colletionName + ", royalties="
				+ royalties + ", nftUrl=" + nftUrl + ", userName=" + userName + "]";
	}

}
