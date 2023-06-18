package fasttrackit.MoviesApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "movies")
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column(name = "release_year")
    private int year;

    @OneToOne
    @JoinColumn(name = "movie_rating")
    private Rating rating;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY)
    private Studio studio;

    public void setActor(Actor actor) {
    }
}