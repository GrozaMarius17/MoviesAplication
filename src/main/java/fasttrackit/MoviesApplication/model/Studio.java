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
@Entity( name = "studios")
public class Studio {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;
    @Column
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "studio", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Movie> movies;
}
