package LogFinder;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    static final int width = 1130;
    static final int height = 670;
    public static Gui GUI = new Gui();

    public static String assemblesrcDir(){
        return Gui.getText2();
    }
    public static String assembledest(){
        return Gui.getText3();
    }
    public static String assembleinputwords(){
        return Gui.getText5();
    }
    public static Gui getGUI(){
        return GUI;
    }

}
