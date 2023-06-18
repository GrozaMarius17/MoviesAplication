package fasttrackit.MoviesApplication.Reader;

import fasttrackit.MoviesApplication.model.Actor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ActorReader {

    private final String pathName;

    private ActorReader(@Value("${initial.data.actors}") String pathName){this.pathName = pathName;}

    public List<Actor> read() {
        List<Actor> actors = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(pathName));
            long id = 1;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                actors.add(fromLine(line, id++));
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return actors;
    }

    private Actor fromLine(String line, long id) {
        System.out.println(line);
        String[] tokens = line.split("\\|");
        Actor.ActorBuilder actorBuilder = Actor.builder()
                .name(tokens[0])
                .birthYear(Integer.parseInt(tokens[1]));
        return actorBuilder.build();
    }

}
