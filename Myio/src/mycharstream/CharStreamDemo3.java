package mycharstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("src/aaaa.txt");
        FileWriter fw=new FileWriter("src/d.txt");

        char[]arr=new char[2];
        int ch;
        while ((ch =fr.read(arr))!=-1) {
            String str = new String(arr,0,ch);
            fw.write(str,0,ch);
        }

        fw.close();
        fr.close();
    }
}
