package dev.pixer.Movies.functionalities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo repository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody , String imdbId ){
        Review review = repository.insert( new Review(reviewBody, LocalDateTime.now(),LocalDateTime.now()));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId)) //where imdbId in the db matches the imdbId which is received from the user
                .apply(new Update().push("reviewIds").value(review))
                .first(); //to make sure that we are getting a single movie and we are updating that

        return review;
    }

}
