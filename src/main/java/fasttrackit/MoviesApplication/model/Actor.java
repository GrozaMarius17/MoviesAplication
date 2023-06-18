package fasttrackit.MoviesApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "actors")
public class Actor {


    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private int birthYear;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Movie> movies;
}
