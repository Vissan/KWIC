package com.company;

import java.io.FileNotFoundException;

public abstract class Filter implements Runnable {
    protected Pipe input;
    protected Pipe output;
    private boolean IsStart = false;

    public Filter(Pipe input, Pipe output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        if (!IsStart) {
            IsStart = true;
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        IsStart = false;
    }

    public void run() {
        try {
            transform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    abstract protected void transform() throws FileNotFoundException, Exception;
}
