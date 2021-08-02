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
        File tree = null;
        int licznik = 0;
        File file = new File(Data.assemblesrcDir());
        File[] listaplikow = file.listFiles();
        List<String> inputValues;
        ArrayList<String> gotthis = new ArrayList<>(l);
        inputValues = Arrays.asList(Data.assembleinputwords().split(" "));
        File dest = new File(Data.assembledest());
        FileWriter fw = new FileWriter(Data.assembledest() + "\\" + "Found texts.txt");
        while (CopyFile.window.isVisible()) {
            for (i = 0; i < Objects.requireNonNull(listaplikow).length; i++) {

                File value = listaplikow[i];
                while (!value.isFile()) {
                    File[] bamboo = listaplikow;
                    file = new File(value.toString());

                    if (Objects.requireNonNull(file.listFiles()).length == 0) {
                        break;
                    }
                    listaplikow = file.listFiles();

                    assert listaplikow != null;
                    value = listaplikow[0];
                    if (value.isFile() && tree == null) {
                        tree = new File(Data.assemblesrcDir());
                    }
                    x = i;
                    if (!value.isFile()) {
                        if (i != listaplikow.length) {
                            while (x != bamboo.length - 1) {
                                assert bamboo[x + 1] != null;
                                if (bamboo[x + 1].length() != 0) {
                                    if (!gotthis.contains(bamboo[x + 1].toString())) {
                                        if (!(bamboo[x + 1] == null)) {
                                            l++;
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
                                if (CopyFile.GUI.Showtext) {
                                    if (strLine.contains(inputValue) || (licznik != 0 && licznik != Gui.getText4())) {
                                        fw.write(strLine);
                                        fw.write("\r\n");
                                        licznik++;

                                        if (licznik == Gui.getText4()) {
                                            break;
                                        }
                                    }
                                }
                                if (CopyFile.GUI.CopyFile) {
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

}
