import LogFinder.CheckIfFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class CalculatorTest {
    @Test
public void testMain() {

        File value = new File("C:/Users/ljjptq/IdeaProjects/junit-tutorial/target/classes/JunitTest/Test2");
        File file = new File("C:/Users/ljjptq/IdeaProjects/junit-tutorial/target/classes/JunitTest/Test2");
        File tree = new File("C:/Users/ljjptq/IdeaProjects/junit-tutorial/target/classes/JunitTest");
        File[] listofFiles = file.listFiles();

        List<File> Paths = new ArrayList<>();
        Paths.add(new File("C:/Users/ljjptq/IdeaProjects/junit-tutorial/target/classes/JunitTest/Test2/Test/Test"));
        Paths.add(new File("C:/Users/ljjptq/IdeaProjects/junit-tutorial/target/classes/JunitTest/Test2/Test"));
        Paths.add(new File("C:/Users/ljjptq/IdeaProjects/junit-tutorial/target/classes/JunitTest/Test2"));
        Assertions.assertEquals(Paths,CheckIfFile.Check(value, listofFiles,tree,file,0,1,null));

        //Test polega na tym, iż program będzie wykonywał się tak długo, aż wartość value nie będzie plikiem tekstowym, w tym czasie program będzie wchodził w coraz głębsze warstwy
        // podanej ścieżki.Aby test wykonał się prawidłowo trzeba zasymulować takie warunki, tak więc zmienna value oznacza znaleziony plik tekstowy, zmienna file oznacza folder w
        // którym się znajduje, natomiast zmienna tree folder, w którym znajduje się file. W skrócie otwierając ścieżkę wyglądałoby to mniejwięcej tak: tree/file/value(txt).
        // W teście porównuje wszystkie trzy wartości uzyskane w programmie, z tymi wpisanymi ręcznie.



    }
}
