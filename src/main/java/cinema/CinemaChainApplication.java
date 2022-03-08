package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cinema.api.service.CinemaInitService;

@SpringBootApplication
public class CinemaChainApplication implements CommandLineRunner {

	private CinemaInitService cinemaService;
	
	@Autowired
	public CinemaChainApplication(CinemaInitService cinemaService) {
		this.cinemaService = cinemaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaChainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		cinemaService.initCities();
	}

}
