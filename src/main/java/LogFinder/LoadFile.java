package LogFinder;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class LoadFile {
    public static int Loading(int licznik, File file, File[] listofFiles, File dest, FileWriter fw, ArrayList<String> inputValues, int i) throws IOException {
        for (int v = 0, listofFilesLength = listofFiles.length; v < listofFilesLength; v++) {
            File listofFile = listofFiles[v];

            if (listofFile.isFile()) {
                Progress.Resultlist.remove(listofFile.toString());
                Gui.pbar.setValue(Progress.progresslength - Progress.Resultlist.size());
                File source = new File(file + "\\" + listofFile.getName());
                FileInputStream fstream = new FileInputStream(file + "\\" + listofFile.getName());
                Path path = Path.of(file + "\\" + listofFile.getName());
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                if ((v != i) && listofFilesLength > 1) {
                    i = v;
                }
                Copynew.countOccurrences(path,inputValues,fw,licznik,source,dest);
                if(Copynew.finishnow){
                    break;
                }
                licznik = 0;
                br.close();
            }
        }
        return i;
    }
}
