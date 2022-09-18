package ZpectrumApp;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.imageio.ImageIO;
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
	 * this method launches the main thread of the program, 
	 * remember to start MySQL8 service before launching.
	 * 
	 * @param args[] es un arreglo con los parámetros
	 * @return void
	 * @author Fran Gonzalez
	 */
	public static void main(String[] args) {

		// SpringApplication.run(ZpectrumApplication.class, args);

		// alternative mode to launch Springboot APP below:
		Properties props = new Properties();
		props.put("spring.main.web-application-type", "NONE");
		props.put("spring.datasource.url", "jdbc:mysql://localhost:3306/zpectrumbbdd");
		props.put("spring.datasource.username", "zpectrumuser");
		props.put("spring.datasource.password", "password");
		props.put("server.port", "8093");
		props.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("spring.jpa.hibernate.ddl-auto", "create-drop");
		props.put("hibernate.physical_naming_strategy",
				"org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
		props.put("hibernate.implicit_naming_strategy",
				"org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
		props.put("spring.jpa.show-sql", "true");
		System.setProperty("java.awt.headless", "false");

		new SpringApplicationBuilder(ZpectrumApplication.class).properties(props).run(args);
		System.out.println("Contexto Spring cargado ¡");

	}

	@Override
	public void run(String... args) throws Exception {

		try {

			FondoApp fondo = null;
			try {
				fondo = new FondoApp(ImageIO.read(new File("Images/FondoApp.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}

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

}
