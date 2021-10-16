package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Shifter extends Filter{

    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<String> lineList = new ArrayList<>();

    public Shifter(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
    protected void transform() throws FileNotFoundException, Exception {
        String line = "";
        while ((line = input.readline())!=null) {
            lineSplitWord(line);
            recombination();
            for (int i=0; i<lineList.size(); i++) {
                output.writeline(lineList.get(i));
            }
            wordList.clear();
            lineList.clear();
        }
        input.closeReader();
        output.closeWriter();
    }

    private void lineSplitWord(String line) {
        String word = "";
        int i = 0;
        while (i<line.length()) {
            if (line.charAt(i) != ' ')
                word += line.charAt(i);
            else {
                wordList.add(word);
                word = "";
            }
            i++;
        }
        //要将最后一个单词添加进去
        if (word.length()>0)
            wordList.add(word);
    }

    private void recombination() {
        for(int j = 0; j < wordList.size(); j++){
            String templine = "";
            for (int k = wordList.size() - 1 - j; k < wordList.size(); k++){
                templine += wordList.get(k) + " ";
            }
            for (int m = 0; m < wordList.size() - 1 - j; m++){
                if(m != wordList.size() - j - 2){
                    templine += wordList.get(m) + " ";
                }
                else{
                    templine += wordList.get(m);
                }
            }
            lineList.add(templine);
        }
    }
}
