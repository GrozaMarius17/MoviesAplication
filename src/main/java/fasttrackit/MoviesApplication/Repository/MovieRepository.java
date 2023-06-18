package fasttrackit.MoviesApplication.Repository;

import fasttrackit.MoviesApplication.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
