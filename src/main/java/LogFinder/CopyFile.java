package LogFinder;

import javax.swing.*;
import java.io.*;

public class CopyFile {
    public static Gui GUI = new Gui();
    static JFrame window = new JFrame();
    public static void Copy() throws IOException {
        window.setSize(Data.width, Data.height);
        window.setResizable(false);
        window.add(GUI);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Loop.LoopUntillPressed();
        ProgramMainLoop.MainLoop();

    }
}
