package mycharstream;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo1 {

    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("src/aaaa.txt");
        //FileWriter fw=new FileWriter("src/d.docx");

       // char[]arr=new char[];

        int ch;
        while ((ch = fr.read())!=-1) {
            System.out.print((char) ch);
        }
    }
}
