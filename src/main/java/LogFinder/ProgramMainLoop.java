package LogFinder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProgramMainLoop {
    static boolean finish;

    public static void MainLoop() throws IOException {
        while (AddFrame.window.isVisible()) {
            Loop.LoopUntillPressed();
            if (Gui.click) {
                Gui.pbar.setMaximum(Progress.progress());
                int i;
                finish = false;
                int l = 1;
                int licznik = 0;
                File tree = null;
                File file = new File(Data.assemblesrcDir());
                FileWriter fw = new FileWriter(Data.assembledest() + "\\" + "Found texts.txt");
                File[] listaplikow = file.listFiles();
                ArrayList<String> gotthis = new ArrayList<>(l);
                File[] progresslist = file.listFiles();
                System.out.println(Arrays.toString(progresslist));
                File dest = new File(Data.assembledest());
                ArrayList<String> inputValues = new ArrayList<>(Arrays.asList(Data.assembleinputwords().split(" ")));
                for (i = 0; i < Objects.requireNonNull(listaplikow).length; i++) {
                    File value = listaplikow[i];
                    List<File> Files = CheckIfFile.Check(value,listaplikow,tree,file,i,l,gotthis);
                    value = Files.get(0);
                    file = Files.get(1);
                    tree = Files.get(2);
                    File[] listofFiles = file.listFiles();
                    assert listofFiles != null;
                    LoadFile.Loading(value, licznik, file, listofFiles, dest, fw, inputValues, i);
                    if(Copynew.finishnow){
                        break;
                    }
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
                    if(Progress.Resultlist.isEmpty()){
                        break;
                    }
                }
                Gui.clearing();
                finish = true;
                Gui.click = false;
                Copynew.finishnow = false;
                fw.close();
            }
        }
    }
}
