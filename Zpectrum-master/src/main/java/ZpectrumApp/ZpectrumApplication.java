package ZpectrumApp;


import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import ZpectrumApp.EventHandler.EventsHandlerMainWindow;
import ZpectrumApp.EventHandler.EventsHandlerPortfolio;
import ZpectrumApp.EventHandler.EventsHandlerUser;
import ZpectrumApp.EventHandler.EventsHandlerWatchlist;
import ZpectrumApp.Peticiones.Peticiones;
import ZpectrumApp.Repositorio.CryptoRepositorio;
import ZpectrumApp.Repositorio.NftRepositorio;
import ZpectrumApp.Repositorio.UsuarioRepositorio;
import ZpectrumApp.Servicio.CryptoServicioIMPL;
import ZpectrumApp.Vista.FondoApp;
import ZpectrumApp.Vista.MainWindow;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 * The Class ZpectrumApplication runs and starts the Springboot application.
 * 
 * @author Francisco González
 * @version 1.0
 */
@SpringBootApplication
public class ZpectrumApplication implements CommandLineRunner {

	@Autowired
	private Peticiones peticiones;

	@Autowired
	private CryptoServicioIMPL servicioIMPL;

	@Autowired
	private UsuarioRepositorio userRepository;

	@Autowired
	private CryptoRepositorio cryptoRepository;

	@Autowired
	private NftRepositorio nftRepository;

	/**
	 * This method launches the main thread of the program. <b>Remember to start
	 * MySQL8 service before launching.</b>
	 *
	 * @author Francisco González
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		// Alternative mode to launch Springboot APP below:
		Properties props = new Properties();
		props.put("spring.main.web-application-type", "NONE");
		props.put("spring.datasource.url", "jdbc:mysql://localhost:3306/zpectrumbbdd");
		props.put("spring.datasource.username", "zpectrumuser");
		props.put("spring.datasource.password", "password");
		props.put("server.port", "8093");
		props.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		//props.put("spring.jpa.hibernate.ddl-auto", "create-drop");
		props.put("spring.jpa.hibernate.ddl-auto", "update");
		props.put("hibernate.physical_naming_strategy",
				"org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
		props.put("hibernate.implicit_naming_strategy",
				"org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
		props.put("spring.jpa.show-sql", "true");
		System.setProperty("java.awt.headless", "false");

		new SpringApplicationBuilder(ZpectrumApplication.class).properties(props).run(args);
		System.out.println("Contexto Spring cargado ¡");

	}



	
	/**
	 * Run the app.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	@Override
	public void run(String... args) throws Exception {

		try {

			FondoApp fondo = null;
			//fondo = new FondoApp(ImageIO.read(new File("FondoApp.png")));
			fondo = new FondoApp((Image) getImage("FondoApp.png"));

			boolean loggedUser = false;
			EventsHandlerPortfolio portfolioWindowHandler = null;
			EventsHandlerWatchlist watchlistWindowHandler = null;

			MainWindow mainwindow = new MainWindow(fondo, peticiones, userRepository, watchlistWindowHandler,
					portfolioWindowHandler, loggedUser, servicioIMPL, nftRepository);

			EventsHandlerMainWindow mainWindowHandler = new EventsHandlerMainWindow(mainwindow, peticiones);
			EventsHandlerUser userWindowHandler = new EventsHandlerUser(userRepository, servicioIMPL, peticiones,
					mainwindow);

			mainwindow.setHandler(mainWindowHandler);
			mainwindow.getUserPanel().setUserHandler(userWindowHandler);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static Image getImage(final String pathAndFileName) {
	    final URL url = Thread.currentThread().getContextClassLoader().getResource(pathAndFileName);
	    return Toolkit.getDefaultToolkit().getImage(url);
	}
}
