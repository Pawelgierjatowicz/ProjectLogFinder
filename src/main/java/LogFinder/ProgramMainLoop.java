package LogFinder;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProgramMainLoop {
    static boolean clear;
    public static void MainLoop() throws IOException {
        int i;
        int x;
        int l = 1;
        int licznik = 0;
        File tree = null;
        File file = new File(Data.assemblesrcDir());
        FileWriter fw = new FileWriter(Data.assembledest() + "\\" + "Found texts.txt");
        File[] listaplikow = file.listFiles();
        ArrayList<String> gotthis = new ArrayList<>(l);
        File dest = new File(Data.assembledest());
        List<String> inputValues = Arrays.asList(Data.assembleinputwords().split(" "));
        while (AddFrame.window.isVisible()) {
            for (i = 0; i < Objects.requireNonNull(listaplikow).length; i++) {
                File value = listaplikow[i];
                tree = CheckIfFile.Check(value,listaplikow,tree,i,l,gotthis);
                File[] listofFiles = file.listFiles();
                assert listofFiles != null;
                LoadFile.Loading(value, licznik, file, listofFiles, dest,fw , inputValues, i);
                if (!(tree == null)) {
                    file = new File(tree.toString());
                    listaplikow = file.listFiles();
                }
                if (!gotthis.isEmpty() && i == Objects.requireNonNull(listaplikow).length - 1) {
                    i = -1;
                    file = new File(gotthis.get(gotthis.size() - 1));
                    System.out.println(gotthis);
                    gotthis.remove(gotthis.size() - 1);
                    listaplikow = file.listFiles();
                    while ((Objects.requireNonNull(listaplikow).length == 0)&&!gotthis.isEmpty()) {
                        file = new File(gotthis.get(gotthis.size() - 1));
                        gotthis.remove(gotthis.size() - 1);
                        listaplikow = file.listFiles();
                    }
                    tree = new File(file.toString());
                }

            }
            fw.close();
        }
    }

}
