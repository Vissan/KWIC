package com.company;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pipe {

    //用Scanner类和PrintWriter类来进行读和写擦作
    private Scanner Preader;
    private PrintWriter Pwriter;

    public Pipe() throws IOException {
        PipedReader Pr = new PipedReader();
        PipedWriter Pw = new PipedWriter();
        //让写的管道和读的管道连接起来
        Pw.connect(Pr);

        Preader = new Scanner(Pr);
        Pwriter = new PrintWriter(Pw);
    }

    public void writeline(String s) throws IOException {
        Pwriter.println(s);
    }

    public String readline() throws IOException {
        if (Preader.hasNextLine()) {
            return Preader.nextLine();
        }
        return null;
    }

    public void closeWriter() throws IOException {
        Pwriter.flush();
        Pwriter.close();
    }

    public void closeReader() throws IOException {
        Preader.close();
    }
}
