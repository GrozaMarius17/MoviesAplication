package fasttrackit.MoviesApplication.Reader;

import fasttrackit.MoviesApplication.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class MoviesReader {
    private final String pathName;

    private MoviesReader(@Value("${initial.data.movies}") String pathName) {
        this.pathName = pathName;
    }

    public List<Movie> readMovies() {
        List<Movie> movies = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(pathName));
            long id = 1;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                movies.add(fromLine(line, id++));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }
    private Movie fromLine(String line, long id) {
        System.out.println(line);
        String[] tokens = line.split("\\|");
        Movie.MovieBuilder movieBuilder = Movie.builder()
                .name(tokens[0])
                .year(Integer.parseInt(tokens[1]));
        return movieBuilder.build();
    }
}
