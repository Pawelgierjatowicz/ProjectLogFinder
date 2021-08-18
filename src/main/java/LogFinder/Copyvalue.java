package LogFinder;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Copyvalue {
    public static boolean finishnow = false;
    private static final int MAP_SIZE = 1048576000; //1000 Megabytes
    public static void countOccurrences (Path path, ArrayList<String> inputValues, FileWriter fw, int licznik, File source, File dest )
    throws IOException {
        int padding = 1;
        int licznik2= 0;
        int counter = 0;
        int z = 0;
        List<byte[]> list = new ArrayList<>();
        byte[] tosearch;
        boolean inword = false;
        boolean scantolineend = false;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        for (String element : inputValues) {
            out.writeUTF(element);
        }
            while(z < inputValues.size()){
                tosearch = inputValues.get(z).getBytes(StandardCharsets.UTF_8);
                list.add(tosearch);
                counter = counter + tosearch.length;
                z ++;
            }
            try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {

                final long length = channel.size();
                int pos = 0;
                outerloop:
                while (pos < length) {
                    long remaining = length - pos;
                    int trymap = MAP_SIZE + counter + padding;
                    int tomap = (int) Math.min(trymap, remaining);
                    int limit = trymap == tomap ? MAP_SIZE : (tomap - counter);
                    MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, pos, tomap);
                    pos += (trymap == tomap) ? MAP_SIZE : tomap;
                    for (int i = 0; i < limit; i++) {
                        byte b = buffer.get(i);
                        if (scantolineend) {
                            if (b == '\n') {
                                scantolineend = false;
                                inword = false;
                            }
                        } else if (b == '\n') {
                            inword = false;
                        } else if (b == '\r' || b == ' ') {
                            inword = false;
                        } else if (!inword) {
                            if (wordMatch(buffer, i, tomap, list, b,inputValues)) {
                                if (Data.getGUI().CopyFile) {
                                    try {
                                        FileUtils.copyFileToDirectory(source, dest);
                                        if(finishnow){
                                            break;
                                        }
                                        if (!Data.getGUI().Showtext) {
                                            break outerloop;
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (Data.getGUI().Showtext || licznik!=0 || licznik2!=0) {
                                    while(licznik!=Gui.getText4()) {
                                        if(i == 0){
                                            break;
                                        }
                                        b = buffer.get(i);
                                        fw.write(buffer.get(i));
                                        i++;
                                        licznik2++;
                                        if(b=='\n'){
                                            licznik2 = 0;
                                            licznik ++;
                                        }
                                    }
                                    if (licznik == Gui.getText4()) {
                                        break outerloop;
                                    }
                                }
                                i += counter;
                                scantolineend = true;
                            } else {
                                inword = true;
                            }
                        }
                    }
                }
            }
        }

    private static boolean wordMatch(MappedByteBuffer buffer, int pos, int tomap, List<byte[]> list, byte b,ArrayList<String> inputValues) {
        int counter = 0;
        int i = 0;
        int v = 0;
        int indexv;
        int indexi;
        byte c;
        boolean found = false;
        boolean foundjustonce;
        outerer:
            while (b != '\n') {
                if(pos+i == tomap){
                    break;
                }
                b = buffer.get(pos + i);
                foundjustonce = false;
                for (int j = 0; j < list.size(); j++) {
                    byte[] bytes = list.get(j);
                    if (bytes[v] == b) {
                        indexv = v;
                        indexi = i;
                        c = b;
                        while (bytes[v] == b) {
                            v++;
                            i++;
                            b = buffer.get(pos + i);
                            counter ++;
                            if (counter == bytes.length) {
                                if(!Data.getGUI().Showtext) {
                                    list.remove(j);
                                    inputValues.remove(j);
                                }
                                if(inputValues.isEmpty()){
                                    found = true;
                                    finishnow = true;
                                    break outerer;
                                }
                                found = true;
                                break outerer;
                            }
                            if (bytes[v] != b) {
                                b = c;
                                i = indexi;
                                v = indexv;
                                counter = 0;
                                foundjustonce = true;
                                break;
                            }
                        }
                    }
                }
            if(foundjustonce){
                i ++;
            }
            i++;
        }
        return found;
    }
}



