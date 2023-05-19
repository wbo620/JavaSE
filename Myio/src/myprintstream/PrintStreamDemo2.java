package myprintstream;

import java.io.*;

public class PrintStreamDemo2 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("src/pw.txt"),true);

        pw.println("花会枯萎");
        pw.print("爱永不凋零");
        pw.printf("\n");

        pw.close();
    }
}
