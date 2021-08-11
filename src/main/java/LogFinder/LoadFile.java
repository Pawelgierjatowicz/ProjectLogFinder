package LogFinder;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LoadFile {
    public static void Loading(File value, int licznik, File file, File[] listofFiles, File dest, FileWriter fw, ArrayList<String> inputValues, int i) throws IOException {
        for (int v = 0, listofFilesLength = listofFiles.length; v < listofFilesLength; v++) {
            File listofFile = listofFiles[v];
            value = listofFile;

            if (listofFile.isFile()) {
                Progress.Resultlist.remove(listofFile.toString());
                Gui.pbar.setValue(Progress.progresslength - Progress.Resultlist.size());
                System.out.println(listofFile);
                System.out.println(Progress.Resultlist.size());

                File source = new File(file + "\\" + listofFile.getName());
                FileInputStream fstream = new FileInputStream(file + "\\" + listofFile.getName());
                Path path = Path.of(file + "\\" + listofFile.getName());
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                if ((v != i) && listofFilesLength > 1) {
                    i = v;
                }
//                CopyValue.GetValue(value, licznik, inputValues, source, dest, fw);
                Copynew.countOccurrences(path,inputValues,fw,licznik,source,dest);
                if(Copynew.finishnow){
                    break;
                }
                licznik = 0;
                br.close();
            }
        }
    }
}
