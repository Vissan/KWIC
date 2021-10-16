package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Output extends Filter{

    private File file;

    public Output(Pipe input, File file) {
        super(input, null);
        this.file = file;
    }

    @Override
    protected void transform() throws FileNotFoundException, Exception {
        final PrintWriter printWriter = new PrintWriter(file);
        String line = "";
        while ((line = input.readline())!=null) {
            printWriter.write(line);
            printWriter.write("\n");
        }
        printWriter.flush();
        printWriter.close();
        input.closeReader();
    }
}
