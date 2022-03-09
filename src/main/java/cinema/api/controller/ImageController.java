package cinema.api.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cinema.store.entity.FilmEntity;
import cinema.store.repository.FilmRepository;


@RestController
@CrossOrigin("*")
public class ImageController {

	private final FilmRepository filmDao;
	private final String src = "/Users/asatutterin/eclipse-workspace/CinemaChain/src/main/resources/static/images/";
	
	@Autowired
	public ImageController(FilmRepository filmDao) {
		super();
		this.filmDao = filmDao;
	}

	//TODO

	@GetMapping(path="/api/images/{filmId}", produces = MediaType.IMAGE_JPEG_VALUE)
	@Transactional
	public byte[] image(@PathVariable("filmId") Long filmId) throws IOException {
		Optional<FilmEntity> film = filmDao.findById(filmId);
		if(film.isPresent()) {
			String photoName = film.get().getImage();
			File file = new File(src
					+photoName+".jpeg");
			Path path = Paths.get(file.toURI());
			return Files.readAllBytes(path);
		}
		return null;
	}
}
