package LogFinder;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class CopyValue {
    public static void GetValue(File value, int licznik, List<String> inputValues, File source, File dest, FileWriter fw) throws IOException {
        String strLine;
        FileReader fileIN = new FileReader(value);
        BufferedReader reader = new BufferedReader(fileIN);
        outerloop:
        while (((strLine = reader.readLine()) != null) && value.canRead()) {
            for (String inputValue : inputValues) {
                if (strLine.length() < inputValue.length()) {
                    strLine = reader.readLine();
                }
                    if (Data.getGUI().CopyFile && (strLine.contains(inputValue))) {
                        try {
                            FileUtils.copyFileToDirectory(source, dest);
                            if (!Data.getGUI().Showtext) {
                                break outerloop;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (Data.getGUI().Showtext && (strLine.contains(inputValue)) || licznik!=0) {
                            fw.write(strLine);
                            fw.write("\r\n");
                            licznik++;
                            if (licznik == Gui.getText4()) {
                                break outerloop;
                            }
                    }
            }
        }
    }
}





