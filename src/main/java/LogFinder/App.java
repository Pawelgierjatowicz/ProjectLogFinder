package LogFinder;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.swing.*;

import org.apache.commons.io.FileUtils;
import java.io.InputStreamReader;

public class App extends javax.swing.JPanel {

    static JFrame okno = new JFrame();
    public static Gui GUI = new Gui();
    static float jobdone = 1;
    static float almostdone = 0;

    public static void main(String[] args) throws IOException {
        Loop.LoopUntillPressed();
        okno.setSize(1130, 670);
        okno.setResizable(false);
        okno.add(GUI);
        okno.setVisible(true);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String srcDir = Gui.getText2();
        File file = new File(srcDir);
        String inputwords = Gui.getText5();
        List<String> inputValues;
        inputValues = Arrays.asList(inputwords.split("\\s*,\\s*"));
        File[] listaplikow = file.listFiles();
        File dest = new File(Gui.getText3());
        FileWriter fw = new FileWriter(dest + "\\" + "Found texts.txt");
        int i;
        int x;
        File tree = null;
        int licznik = 0;
        ArrayList<String> gotthis = new ArrayList<>(100);
        assert listaplikow != null;

        for (i = 0; i < Objects.requireNonNull(listaplikow).length; i++) {
            File value = listaplikow[i];

            while (!value.isFile()) {
                File[] bamboo = listaplikow;
                file = new File(value.toString());

                if (Objects.requireNonNull(file.listFiles()).length == 0) {
                    jobdone = jobdone / listaplikow.length;

                    for (int l = 0; l < listaplikow.length; l++) {
                        if (bamboo[l].length() == 0) {
                            almostdone = almostdone + jobdone;
                        }
                    }
                    break;
                }
                listaplikow = file.listFiles();

                assert listaplikow != null;
                value = listaplikow[0];
                if (value.isFile() && tree == null) {
                    tree = new File(srcDir);
                }
                x = i;
                if (!value.isFile()) {
                    if (i != listaplikow.length) {
                        while (x != bamboo.length - 1) {
                            assert bamboo[x + 1] != null;
                            if (bamboo[x + 1].length() != 0) {
                                if (!gotthis.contains(bamboo[x + 1].toString())) {
                                    if (!(bamboo[x + 1] == null)) {
                                        jobdone = (float) (1.0 / bamboo.length);
                                        almostdone = almostdone + jobdone;
                                        System.out.println(almostdone);
                                        gotthis.add(bamboo[x + 1].toString());
                                        x++;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                x++;
                            }
                        }
                    }
                    i = 0;
                    tree = new File(file.toString());
                }
                if (value.isFile()) {
                    break;
                }
            }

            File[] listofFiles = file.listFiles();
            assert listofFiles != null;

            for (int v = 0, listofFilesLength = listofFiles.length; v < listofFilesLength; v++) {
                File listofFile = listofFiles[v];
                if (listofFile.isFile()) {
                    File source = new File(file + "\\" + listofFile.getName());
                    FileInputStream fstream = new FileInputStream(file + "\\" + listofFile.getName());
                    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                    String strLine;

                    if (v != i) {
                        i = v;
                    }
                    while ((strLine = br.readLine()) != null && value.canRead()) {
                        for (String inputValue : inputValues) {
                            if (GUI.Showtext) {
                                if (strLine.contains(inputValue) || (licznik != 0 && licznik != Gui.getText4())) {
                                    fw.write(strLine);
                                    fw.write("\r\n");
                                    licznik++;

                                    if (licznik == Gui.getText4()) {
                                        break;
                                    }
                                }
                            }
                            if (GUI.CopyFile) {
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
                    licznik = 0;

                    br.close();
                }
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
                while (Objects.requireNonNull(listaplikow).length - 1 == 0) {
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





        



