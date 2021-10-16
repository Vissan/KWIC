package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            //输入和输出的文件地址
            File input1 = new File("E:\\eclipse-workplace\\test\\input1.txt");
            File output1 = new File("E:\\eclipse-workplace\\test\\output1.txt");
//            File input2 = new File("E:\\eclipse-workplace\\test\\input2.txt");
//            File output2 = new File("E:\\eclipse-workplace\\test\\output2.txt");

            Scanner inputfile1 = new Scanner(input1);
//            Scanner inputfile2 = new Scanner(input2);
            Scanner outputfile1 = new Scanner(output1);
//            Scanner outputfile2 = new Scanner(output2);

            //定义三个管道
            Pipe in_cs = new Pipe();
            Pipe cs_al = new Pipe();
            Pipe al_out = new Pipe();

            //定义四种过滤器
            Input input = new Input(input1, in_cs);
            Shifter shifter = new Shifter(in_cs, cs_al);
            Alphabetizer alphabetizer = new Alphabetizer(cs_al, al_out);
            Output output = new Output(al_out, output1);

            //直接顺序执行四个过滤器
            input.transform();
            shifter.transform();
            alphabetizer.transform();
            output.transform();

//            Input input_2 = new Input(input2, in_cs);
//            Shifter shifter_2 = new Shifter(in_cs, cs_al);
//            Alphabetizer alphabetizer_2 = new Alphabetizer(cs_al, al_out);
//            Output output_2 = new Output(al_out, output2);
//
            //添加welcome to chengdu
//            input_2.add_transform();
//            shifter_2.transform();
//            alphabetizer_2.transform();
//            output_2.transform();

            System.out.println("-----  in1   -----");
            while (inputfile1.hasNextLine()) {
                System.out.println(inputfile1.nextLine());
            }

            System.out.println("-----  out1  -----");
            while (outputfile1.hasNextLine()) {
                System.out.println(outputfile1.nextLine());
            }

//            System.out.println("-----  in2   -----");
//            while (inputfile2.hasNextLine()) {
//                System.out.println(inputfile2.nextLine());
//            }
//
//            System.out.println("-----  out2  -----");
//            while (outputfile2.hasNextLine()) {
//                System.out.println(outputfile2.nextLine());
//            }
            inputfile1.close();
            outputfile1.close();
//            inputfile2.close();
//            outputfile2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
