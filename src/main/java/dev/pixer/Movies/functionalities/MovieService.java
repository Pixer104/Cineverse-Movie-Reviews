package dev.pixer.Movies.functionalities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService {

    @Autowired  //marks the MovieRepository field for automatic wiring with an instance of MovieRepository
    private MovieRepository movieRepository;  //movieRepository field interact with DB to perform operation.

    public List<Movie> findAllMovies(){
        return movieRepository.findAll(); //retrieve all movies from the DB and return them as a list of movies object.
    }

    public Optional<Movie> findMovieByImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }


}
