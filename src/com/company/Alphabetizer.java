package com.company;

import java.io.FileNotFoundException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class Alphabetizer extends Filter {

    private ArrayList<String> alpha = new ArrayList<>();

    public Alphabetizer(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
    protected void transform() throws FileNotFoundException, Exception {
        String line = "";
        while ((line = input.readline())!=null) {
            alpha.add(line);
        }

        Collections.sort(alpha, new sorted());
        for (int i=0; i<alpha.size(); i++) {
            output.writeline(alpha.get(i));
        }
        input.closeReader();
        output.closeWriter();
    }

    private class sorted implements Comparator<String> {

        private Collator collator;

        public sorted() {
            this.collator = Collator.getInstance(Locale.ENGLISH);
        }
        @Override
        public int compare(String o1, String o2) {
            return this.collator.compare(o1, o2);
        }
    }

}
