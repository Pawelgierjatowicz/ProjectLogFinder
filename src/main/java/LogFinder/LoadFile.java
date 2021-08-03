package LogFinder;

import java.io.*;
import java.util.List;

public class LoadFile {
    public static void Loading(File value, int licznik, File file, File[] listofFiles, File dest, FileWriter fw, List<String> inputValues, int i) throws IOException {
        for (int v = 0, listofFilesLength = listofFiles.length; v < listofFilesLength; v++) {
            File listofFile = listofFiles[v];
            if (listofFile.isFile()) {
                File source = new File(file + "\\" + listofFile.getName());
                FileInputStream fstream = new FileInputStream(file + "\\" + listofFile.getName());
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                if ((v != i) && listofFilesLength > 1) {
                    i = v;
                }
                CopyValue.GetValue(value, licznik, inputValues, source, dest, br, fw);
                br.close();
            }
        }
    }
}
