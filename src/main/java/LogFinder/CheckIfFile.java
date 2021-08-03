package LogFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class CheckIfFile {
    public static File Check(File value, File[] listaplikow, File tree, int i, int l, ArrayList<String> gotthis) {
        while (!value.isFile()) {
            File[] bamboo = listaplikow;
            File file = new File(value.toString());
            if (Objects.requireNonNull(file.listFiles()).length == 0) {
                break;
            }
            listaplikow = file.listFiles();

            assert listaplikow != null;
            value = listaplikow[0];
            if (value.isFile() && tree == null) {
                tree = new File(Data.assemblesrcDir());
            }
            int x = i;
            if (!value.isFile()) {
                if (i != listaplikow.length) {
                    while (x != bamboo.length - 1) {

                        assert bamboo[x + 1] != null;
                        if (!(Objects.requireNonNull(bamboo[x + 1].listFiles()).length == 0)) {
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

                tree = new File(file.toString());
            }
            if (value.isFile()) {
                break;
            }
        }
        return tree;
    }
}
