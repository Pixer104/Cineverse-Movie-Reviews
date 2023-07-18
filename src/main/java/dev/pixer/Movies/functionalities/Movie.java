package dev.pixer.Movies.functionalities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data // takes care of all those getter setter and to string method
@AllArgsConstructor // for creating constructor that takes all these private fields as Arguments
@NoArgsConstructor
public class Movie {


    @Id //let framework know to treat the oject property as the unique identifier for each of the movie
    private ObjectId id;

    private String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    //it'll cause the database to store only the id's of the reviews  and the reviews will be in separate collection
    private List<Review> reviewIds;

    public Movie(String imdbId, String title, String releaseDate, String trailerlink, String poster, List<String> backdrops, List<String> genres){
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.backdrops = backdrops;
        this.genres = genres;

    }
}
