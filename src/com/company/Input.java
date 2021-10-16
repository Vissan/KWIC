package com.company;

import java.io.File;
import java.util.Scanner;

public class Input extends Filter{

    private File infile;

    public Input(File file, Pipe output) {
        super(null, output);
        this.infile = file;
    }

    @Override
    /**
     * 读取数据
     */
    protected void transform() throws Exception {
        Scanner scanner = new Scanner(infile);
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            output.writeline(line);
        }
        output.closeWriter();
        scanner.close();
    }

    protected void add_transform() throws Exception {
        Scanner scanner = new Scanner(infile);
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            output.writeline(line);
        }
        output.writeline("welcom to chengdu");
        output.closeWriter();
        scanner.close();
    }
}
