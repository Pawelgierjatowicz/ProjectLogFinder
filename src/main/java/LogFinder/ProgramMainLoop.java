package LogFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProgramMainLoop {
    static boolean finish;
    static boolean srcexist = false;
    static boolean dstexist = false;
    public static void MainLoop() throws IOException {
        while (AddFrame.window.isVisible()) {
            Loop.LoopUntillPressed();
            Path source = Paths.get(Data.assemblesrcDir());
            if(!Files.exists(source)){
                Gui.jLabel4.setVisible(true);
                Gui.jLabel4.setText("The source location doesn't exist");
                srcexist = true;
            }
            Path destiny = Paths.get(Data.assembledest());
            if(!Files.exists(destiny)){
                Gui.jLabel4.setVisible(true);
                Gui.jLabel4.setText("The destiny location doesn't exist");
                dstexist = true;
            }
            if (Gui.click & !srcexist & !dstexist) {
                Gui.jLabel4.setText("");
                Gui.jLabel4.setVisible(true);
                Gui.pbar.setMaximum(Progress.progress());
                int i;
                finish = false;
                int l = 1;
                int licznik = 0;
                File tree = null;
                File file = new File(Data.assemblesrcDir());
                FileWriter fw;
                if(Data.getGUI().Showtext) {
                    fw = new FileWriter(Data.assembledest() + "\\" + "Found texts.txt");
                } else {
                    fw = null;
                }
                File[] listaplikow = file.listFiles();
                ArrayList<String> gotthis = new ArrayList<>(l);

                File dest = new File(Data.assembledest());
                ArrayList<String> inputValues = new ArrayList<>(Arrays.asList(Data.assembleinputwords().split(" ")));
                for (i = 0; i < Objects.requireNonNull(listaplikow).length; i++) {
                    File value = listaplikow[i];
                    List<File> Files = CheckIfFile.Check(value,listaplikow,tree,file,i,l,gotthis);
                    file = Files.get(1);
                    tree = Files.get(2);
                    File[] listofFiles = file.listFiles();
                    assert listofFiles != null;
                    i = LoadFile.Loading(licznik, file, listofFiles, dest, fw, inputValues, i);
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

                if(!(fw == null)) {
                    fw.close();
                }
            }
            srcexist = false;
            dstexist = false;
            Gui.clearing();
            finish = true;
            Gui.click = false;
            Copynew.finishnow = false;
        }
    }
}
