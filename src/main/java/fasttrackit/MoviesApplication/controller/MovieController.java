package fasttrackit.MoviesApplication.controller;

import fasttrackit.MoviesApplication.model.Movie;
import fasttrackit.MoviesApplication.model.Review;
import fasttrackit.MoviesApplication.service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/{id}/reviews")
    Movie addReviewToMovie(@PathVariable int id, @RequestBody Review review) {
        return movieService.addReviewToMovie(id, review);
    }

    @PostMapping("/{id}/studio/{studioId}")
    Movie addMovieToStudio(@PathVariable int id, @PathVariable int studioId) {
        return movieService.addMovieToStudio(id, studioId);
    }

    @PostMapping("{id}/actor/{actorId}")
    Movie addActorToMovie(@PathVariable int id, @PathVariable int actorId) {
        return movieService.addActorToMovie(id, actorId);
    }

}
