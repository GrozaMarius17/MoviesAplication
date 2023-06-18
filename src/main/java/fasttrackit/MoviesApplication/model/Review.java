package fasttrackit.MoviesApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String text;

    @Column
    private String reviewer;

    @ManyToOne
    @JsonIgnore
    private Movie movie;
}
