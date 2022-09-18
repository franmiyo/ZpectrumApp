package ZpectrumApp.Vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;

import ZpectrumApp.DTO.CryptoDTO;
import ZpectrumApp.DTO.NftDTO;
import ZpectrumApp.EventHandler.EventsHandlerPortfolio;
import ZpectrumApp.Modelo.Nft;
import ZpectrumApp.Modelo.Usuario;
import ZpectrumApp.Repositorio.UsuarioRepositorio;
import net.miginfocom.swing.MigLayout;

public class PortfolioPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9112234017946580041L;

	private JPanel contentPanePortfolio;
	// private Usuario user;
	private JLabel name, erd, balance, tokensList, totalValue, nftList;
	private JList<String> tokensFList;
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JTable nftTable;
	private Font fuente1 = new Font("Tahoma", Font.PLAIN, 22);
	private MainWindow mainWindow;
	private JButton updateBtn, copyBtn;
	private int nftCount = 0;
	private int videoCount = 0;
	private DefaultTableModel nftModel;
	private String nftVideoName = "Video/nftVideo" + videoCount + ".mp4";

	public JButton getUpdateBtn() {
		return updateBtn;
	}

	public JButton getCopyBtn() {
		return copyBtn;
	}

	public JLabel getErd() {
		return erd;
	}

	public JLabel getBalance() {
		return balance;
	}

	public JLabel getTokensList() {
		return tokensList;
	}

	public JLabel getTotalValue() {
		return totalValue;
	}

	public JLabel getNftList() {
		return nftList;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public JPanel getContentPanePortfolio() {
		return contentPanePortfolio;
	}

	public PortfolioPanel(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
		setUI();

	}

	private void setUI() {

		contentPanePortfolio = new JPanel(new MigLayout("fill", "[grow][grow]", "[][][][][][]"));
		contentPanePortfolio.setFont(fuente1);

		name = new JLabel("Name: " + mainWindow.getUser().getUserName().toUpperCase());
		contentPanePortfolio.add(name, "cell 0 0");

		erd = new JLabel("Erd: " + mainWindow.getUser().getErd());
		contentPanePortfolio.add(erd, "cell 0 1");

		balance = new JLabel("Egld balance: " + mainWindow.getUser().getBalance());
		contentPanePortfolio.add(balance, " cell 0 2");

		tokensList = new JLabel("Tokens : ");
		contentPanePortfolio.add(tokensList, "cell 0 3");
		contentPanePortfolio.add(new JScrollPane(setTokensList()), "cell 0 3");

		nftList = new JLabel("Nfts: ");
		contentPanePortfolio.add(nftList, "cell 1 3");
		contentPanePortfolio.add(new JScrollPane(setNftTable()), "cell 1 3");

		totalValue = new JLabel("Total tokens value: " + totalValue() + " $");
		contentPanePortfolio.add(totalValue, "cell 0 5");

		updateBtn = new JButton("Update");
		contentPanePortfolio.add(updateBtn, "cell 1 1");

		copyBtn = new JButton("Copy adress");
		contentPanePortfolio.add(copyBtn, "cell 0 1");

	}

	private JList<String> setTokensList() {

		tokensFList = new JList<>(listModel);
		tokensFList.setPreferredSize(new Dimension(500, 800));
		List<CryptoDTO> cryptoList = mainWindow.getPeticiones().obtainTokensAccount(mainWindow.getUser().getErd());
		if (cryptoList.isEmpty()) {
			listModel.addElement("No hay tokens");
		} else {
			for (CryptoDTO cryptoDTO : cryptoList) {
				listModel.addElement(cryptoDTO.getCryptoName().toUpperCase() + ": " + cryptoDTO.getBalance()
						+ " Value: " + cryptoDTO.getValueUSD());
			}
		}

		return tokensFList;
	}

	private String totalValue() {

		double totalPrice = 0.0;
		List<CryptoDTO> cryptoList = mainWindow.getPeticiones().obtainTokensAccount(mainWindow.getUser().getErd());
		for (CryptoDTO cryptoDTO : cryptoList) {
			totalPrice += cryptoDTO.getValueUsd();
		}
		String response = String.valueOf(totalPrice);
		return response;
	}

	@SuppressWarnings("serial")
	private JTable setNftTable() {

		List<NftDTO> nfts = mainWindow.getPeticiones().obtainNftAccount(mainWindow.getUser().getErd());
		String[] columsName = new String[] { "Nu.", "Name", "Collection name", "royalties", "Image" };
		nftModel = new DefaultTableModel(5, columsName.length) {
			@Override
			public Class<?> getColumnClass(int column) {
				if (column == 4) {
					return ImageIcon.class;
				}
				return Object.class;

			}
		};
		nftModel.setColumnIdentifiers(columsName);

		for (NftDTO nft : nfts) {
			// TODO añadir una imagen del nft como ultima columna
			System.out.println(nft.getNftUrl());
			if (nft.getNftUrl() == null) {
				nft.setNftUrl("There is no URL");
			}
			nftModel.addRow(new Object[] { countNft(), nft.getNftName(), nft.getColletionName(), nft.getRoyalties(),
					nftImage(nft.getNftUrl()) });
		}
		nftModel.removeRow(0);
		nftModel.removeRow(1);

		nftTable = new JTable(nftModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// disable editing:
				return false;
			}
		};
		nftTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		nftTable.getColumnModel().getColumn(3).setPreferredWidth(5);
		nftTable.setRowHeight(70);
		nftModel.removeRow(0);
		nftModel.removeRow(1);
		nftModel.removeRow(2);

		return nftTable;
	}

	private String countNft() {
		nftCount++;
		String resultNumber = String.valueOf(nftCount);
		return resultNumber;
	}

	private ImageIcon nftImage(String url2) {
		if (url2.contains("There is no URL")) {
			ImageIcon imageResult = new ImageIcon("Images/nonenft.jpg");
			return imageResult;
		} else {

			HttpURLConnection urlConnection;

			try {
				urlConnection = (HttpURLConnection) new URL(url2).openConnection();
				urlConnection.setInstanceFollowRedirects(true);
				HttpURLConnection.setFollowRedirects(true);

				int status = urlConnection.getResponseCode();
				if (status >= 300 && status <= 307) {
					url2 = urlConnection.getHeaderField("Location");
					urlConnection = (HttpURLConnection) new URL(url2).openConnection();
					System.out.println("Redirect to URL : " + url2);
				}
				String contentType = urlConnection.getHeaderField("Content-Type");

				if (contentType.startsWith("image/")) {

					return processImage(urlConnection);

					} else if (contentType.contains("video/")) {
					videoCount++;
					// save video first
					try (BufferedInputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
							FileOutputStream fileOS = new FileOutputStream(nftVideoName)) {
						byte data[] = new byte[1024];
						int byteContent;
						while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
							fileOS.write(data, 0, byteContent);
						}
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					// process video then
					return processVideo(nftVideoName);

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		ImageIcon imageResult = new ImageIcon("Images/nonenft.jpg");
		return imageResult;
	}

	private ImageIcon processImage(HttpURLConnection urlConnection) {
		BufferedImage processImage = null;
		byte[] imageInByte = null;
		try {

			processImage = ImageIO.read(urlConnection.getURL());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(processImage, "jpg", baos);
			imageInByte = baos.toByteArray();


		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageIcon image0 = new ImageIcon(processImage);
		Image image = image0.getImage();
		Image image2 = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		ImageIcon imageResult = new ImageIcon(image2);
		System.out.println("imagen");
		
		List<Nft> nftList = mainWindow.getUser().getNftList();

		for (Nft nft : nftList) {
			nft.setNftImage(imageInByte);
			mainWindow.getNftRepository().save(nft);
		}
		
		return imageResult;
	}

	private ImageIcon processVideo(String nftVideoName) {

		Picture frame = null;
		ImageIcon imageResult;
		byte[] imageInByte = null;
		BufferedImage bufferedImage = null;

		try {

			frame = FrameGrab.getFrameAtSec(new File(nftVideoName), 1.0);
			bufferedImage = AWTUtil.toBufferedImage(frame);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", baos);
			imageInByte = baos.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JCodecException e) {
			e.printStackTrace();
		}
		
		List<Nft> nftList = mainWindow.getUser().getNftList();

		for (Nft nft : nftList) {
			nft.setNftImage(imageInByte);
			mainWindow.getNftRepository().save(nft);
		}
		
		ImageIcon image0 = new ImageIcon(bufferedImage);
		Image imageProcess = image0.getImage();
		Image image2 = imageProcess.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		imageResult = new ImageIcon(image2);
		System.out.println("video");

		return imageResult;
	}

	public void repaintComponents() {
		videoCount = 0;
		name.setText("Name: " + mainWindow.getUser().getUserName().toUpperCase());
		erd.setText("Erd: " + mainWindow.getUser().getErd());
		balance.setText("Egld balance: " + mainWindow.getUser().getBalance());
		repaintTokensList();
		repaintNftTable();
		totalValue.setText("Total tokens value: " + totalValue() + " $");

	}

	private void repaintTokensList() {
		listModel.removeAllElements();
		List<CryptoDTO> cryptoList = mainWindow.getPeticiones().obtainTokensAccount(mainWindow.getUser().getErd());
		if (cryptoList.isEmpty()) {
			listModel.addElement("No hay tokens");
		} else {
			for (CryptoDTO cryptoDTO : cryptoList) {
				listModel.addElement(cryptoDTO.getCryptoName().toUpperCase() + ": " + cryptoDTO.getBalance()
						+ " Value: " + cryptoDTO.getValueUSD());
			}
		}
	}

	private void repaintNftTable() {
		nftModel.setRowCount(0);
		nftCount = 0;
		List<NftDTO> nfts = mainWindow.getPeticiones().obtainNftAccount(mainWindow.getUser().getErd());

		for (NftDTO nft : nfts) {
			// TODO añadir una imagen del nft como ultima columna
			System.out.println(nft.getNftUrl());
			if (nft.getNftUrl() == null) {
				nft.setNftUrl("There is no URL");
			}
			nftModel.addRow(new Object[] { countNft(), nft.getNftName(), nft.getColletionName(), nft.getRoyalties(),
					nftImage(nft.getNftUrl()) });
		}

	}

	public void setPortfolioHandler(EventsHandlerPortfolio handler) {

		updateBtn.addActionListener(handler);
		copyBtn.addActionListener(handler);

	}

}
