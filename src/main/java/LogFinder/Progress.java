package LogFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Progress {
    static List<String> Resultlist = null;
    static int progresslength;
    public static int progress(){
        try (Stream<Path> walk = Files.walk(Paths.get(Data.assemblesrcDir()))) {
            Resultlist = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        progresslength = Resultlist.size();
        return progresslength;
    }
}
