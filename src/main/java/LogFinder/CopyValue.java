package LogFinder;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CopyValue {
    public static void GetValue(File value, int licznik, List<String> inputValues, File source, File dest, BufferedReader br, FileWriter fw) throws IOException {
        String strLine;
        while ((strLine = br.readLine()) != null && value.canRead()) {
            for (String inputValue : inputValues) {
                if (Data.getGUI().Showtext) {
                    if (strLine.contains(inputValue) || (licznik != 0 && licznik != Gui.getText4())) {
                        fw.write(strLine);
                        fw.write("\r\n");
                        licznik++;

                        if (licznik == Gui.getText4()) {
                            break;
                        }
                    }
                }
                if (Data.getGUI().CopyFile) {
                    if (strLine.contains(inputValue)) {
                        try {
                            FileUtils.copyFileToDirectory(source, dest);
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}



