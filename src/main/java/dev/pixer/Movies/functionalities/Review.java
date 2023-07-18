package dev.pixer.Movies.functionalities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {


    @Id
    private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;

    //since IDs are auto-generated so we can't pass ids to this class, therefore we'll generate constructor which take only body
    public Review(String body, LocalDateTime created, LocalDateTime updated) {

        this.body = body;
        this.created = created;
        this.updated = updated;
    }

}
