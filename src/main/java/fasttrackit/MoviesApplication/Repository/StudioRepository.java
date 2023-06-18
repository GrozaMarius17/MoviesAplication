package fasttrackit.MoviesApplication.Repository;

import fasttrackit.MoviesApplication.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer> {
}
