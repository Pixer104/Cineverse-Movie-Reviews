package dev.pixer.Movies.functionalities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService Service;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<List<Movie>>(Service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{ImdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String ImdbId) {
        return new ResponseEntity<Optional<Movie>>(Service.findMovieByImdbId(ImdbId), HttpStatus.OK);
    }
}
