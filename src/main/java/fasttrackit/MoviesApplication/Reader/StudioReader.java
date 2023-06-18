package fasttrackit.MoviesApplication.Reader;

import fasttrackit.MoviesApplication.model.Studio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class StudioReader {

    private final String pathName;

    private StudioReader(@Value("${initial.data.studios}") String pathName){this.pathName = pathName;}

    public List<Studio> read() {
        List<Studio> studio = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(pathName));
            long id = 1;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                studio.add(fromLine(line, id++));
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return studio;
    }

    private Studio fromLine(String line, long id) {
        System.out.println(line);
        String[] tokens = line.split("\\|");
        Studio.StudioBuilder studioBuilder = Studio.builder()
                .name(tokens[0])
                .address(tokens[1]);
        return studioBuilder.build();
    }

}

