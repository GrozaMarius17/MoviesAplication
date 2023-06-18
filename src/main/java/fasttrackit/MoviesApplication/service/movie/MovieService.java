package fasttrackit.MoviesApplication.service.movie;

import fasttrackit.MoviesApplication.Reader.*;
import fasttrackit.MoviesApplication.Repository.*;
import fasttrackit.MoviesApplication.model.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MoviesReader moviesReader;

    private final MovieRepository movieRepository;

    private final RatingRepository ratingRepository;

    private final RatingReader ratingReader;

    private final ReviewRepository reviewRepository;

    private final ReviewReader reviewReader;

    private final StudioReader studioReader;
    private final StudioRepository studioRepository;

    private final ActorRepository actorRepository;

    private final ActorReader actorReader;


    @PostConstruct
    public void init() {
        List<Rating> ratings = ratingReader.read();
        ratingRepository.saveAll(ratings);
        List<Movie> movies = moviesReader.readMovies();
        for (int i = 0; i < movies.size(); i++ ) {
            movies.get(i).setRating(ratings.get(i));
        }
        List<Review> reviews = reviewReader.read();
        reviewRepository.saveAll(reviews);
        movieRepository.saveAll(movies);
        List<Studio> studios = studioReader.read();
        studioRepository.saveAll(studios);

    }

    public Movie addReviewToMovie(int movieId, Review review) {
        Movie m = movieRepository.getReferenceById(movieId);
        review.setMovie(m);
        m.getReviews().add(review);
        return movieRepository.save(m);
    }

    public Movie addMovieToStudio(int movieId, int studioId) {
        Studio studio = studioRepository.findById(studioId).get();
        Movie movie = movieRepository.findById(movieId).get();
        movie.setStudio(studio);
        return movieRepository.save(movie);
    }

    public Movie addActorToMovie(int movieId, int actorId) {
        Actor actor = actorRepository.findById(actorId).get();
        Movie movie = movieRepository.findById(movieId).get();
        movie.setActor(actor);
        return movieRepository.save(movie);
    }

    public ActorReader getActorReader() {
        return actorReader;
    }
}
