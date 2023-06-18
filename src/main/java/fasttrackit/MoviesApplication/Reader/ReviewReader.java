package fasttrackit.MoviesApplication.Reader;

import fasttrackit.MoviesApplication.model.Review;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ReviewReader {
    private final String pathName;

    private ReviewReader(@Value("${initial.data.reviews}") String pathName){this.pathName = pathName;}
    public List<Review> read() {
        List<Review> reviews = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(pathName));
            long id = 1;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                reviews.add(fromLine(line, id++));
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }

    private Review fromLine(String line, long id) {
        System.out.println(line);
        String[] tokens = line.split("\\|");
        Review.ReviewBuilder reviewBuilder = Review.builder()
                .text(tokens[0])
                .reviewer(tokens[1]);
        return reviewBuilder.build();
    }
}
