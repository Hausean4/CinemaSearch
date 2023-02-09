package ch.zhaw.CineSearch.boundary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.CineSearch.entity.Movie;
import ch.zhaw.CineSearch.entity.MovieRepository;
import ch.zhaw.CineSearch.entity.Times;
import ch.zhaw.CineSearch.entity.TimesRepository;


@RestController
public class MovieEndpoint {

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    public TimesRepository timesRepository;

    @GetMapping(path="/api/movies")
    public List<Movie> listAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping(path="/api/movies/{movieName}")
    public ResponseEntity<List<Times>> getMovieName(@PathVariable("movieName") String movieName) {
        Optional<Movie> movie = movieRepository.findByMovieName(movieName);
        if(movie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            List<Times> times = timesRepository.findByMovie(movie.get());
            return new ResponseEntity<>(times,HttpStatus.OK);
        }
    }
}
