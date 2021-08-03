package LogFinder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProgramMainLoop {
    static boolean clear;
    static boolean finish;
    CheckIfFile check = new CheckIfFile();
    public static void MainLoop() throws IOException {
        while (AddFrame.window.isVisible()) {
            Loop.LoopUntillPressed();
            if (Gui.click) {
                int i;
                finish = false;
                int l = 1;
                int licznik = 0;
                File tree = null;
                File file = new File(Data.assemblesrcDir());
                FileWriter fw = new FileWriter(Data.assembledest() + "\\" + "Found texts.txt");
                File[] listaplikow = file.listFiles();
                ArrayList<String> gotthis = new ArrayList<>(l);
                File dest = new File(Data.assembledest());
                List<String> inputValues = Arrays.asList(Data.assembleinputwords().split(" "));
                for (i = 0; i < Objects.requireNonNull(listaplikow).length; i++) {
                    File value = listaplikow[i];
                    List<File> Files = CheckIfFile.Check(value,listaplikow,tree,file,i,l,gotthis);
                    value = Files.get(0);
                    file = Files.get(1);
                    tree = Files.get(2);
                    File[] listofFiles = file.listFiles();
                    assert listofFiles != null;
                    LoadFile.Loading(value, licznik, file, listofFiles, dest, fw, inputValues, i);
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
                        while ((Objects.requireNonNull(listaplikow).length == 0) && !gotthis.isEmpty()) {
                            file = new File(gotthis.get(gotthis.size() - 1));
                            gotthis.remove(gotthis.size() - 1);
                            listaplikow = file.listFiles();
                        }
                        tree = new File(file.toString());
                    }
                }
                Gui.clearing();
                finish = true;
                Gui.click = false;
                fw.close();
            }
        }
    }
}
