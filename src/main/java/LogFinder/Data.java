package LogFinder;

import javax.swing.*;
import java.io.File;

public class Data {
    static final int width = 1130;
    static final int height = 670;
    public static String assemblesrcDir(){
        return Gui.getText2();
    }
    public static String assembledest(){
        return Gui.getText3();
    }
    public static String assembleinputwords(){
        return Gui.getText5();
    }
}
