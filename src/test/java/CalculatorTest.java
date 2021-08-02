import LogFinder.Gui;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
public void testMain() throws Exception {
    System.out.println("main");
    String[] args = null;
    final InputStream original = System.in;
    final FileInputStream fips = new FileInputStream("Pathtofile");
        System.setIn(fips);
        Main.main(args);
        System.setIn(original);
    }
}
