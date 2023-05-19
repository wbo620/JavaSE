package mycharstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("src/aaaa.txt");


        char[]arr=new char[2];
        int ch;
        while ((ch = fr.read(arr))!=-1) {
            System.out.print(new String(arr,0,ch));

        }
        fr.close();
    }
}
