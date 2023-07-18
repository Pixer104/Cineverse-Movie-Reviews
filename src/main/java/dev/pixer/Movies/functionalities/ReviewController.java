package dev.pixer.Movies.functionalities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@CrossOrigin (origins = "http://localhost:3000/")
@RequestMapping("/api/reviews")

public class ReviewController {

    @Autowired
    private ReviewService Service;

    @PostMapping
    public ResponseEntity<Review> createReview (@RequestBody Map<String , String> payload){
        return new ResponseEntity<Review>(Service.createReview(payload.get("reviewBody") , payload.get("imdbId")) , HttpStatus.OK);

    }

}
