package com.Batch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Batch {

    private BufferedReader in;//输入缓冲对象
    private BufferedWriter out;//输出缓冲对象
    private ArrayList<String> wordList;
    private ArrayList<String> wordList2;

    public Batch (String file) throws Exception {
        wordList = new ArrayList<String>();
        wordList2 = new ArrayList<>();
        String line="";
        open(file);//打开文件
        System.out.println("读入的源程序:");
        while (line!= null) {
            line=readline();
            System.out.println(line);
            if (line !=null)
            {
                shifter(line, wordList);//每行移位
            }
        }
        Alph(wordList);//排序
        System.out.println("Output:");
        display(wordList);
        write(wordList,"E:\\TestUse\\out.txt");//结果写入文件
        wordList.add("welcome to chengdu");
        write(wordList, "E:\\TestUse\\in2.txt");
        out.flush();
        //新加操作

        System.out.println("操作二*********************");
        open("E:\\TestUse\\in2.txt");
        System.out.println("读入的源程序:");
        String line_2 = "";
        while (line_2!=null) {
            line_2 = readline();
            System.out.println(line_2);
            if (line !=null) {
                shifter(line, wordList2);//每行移位
            }
        }
        Alph(wordList2);
        System.out.println("Output:");
        display(wordList2);
        write(wordList, "E:\\TestUse\\out2.txt");
        out.flush();
        out.close();

    }
    public void open(String InputFilename) { //打开文件函数
        try {
            in = new BufferedReader(new FileReader(InputFilename));//从文件中读取
        } catch (IOException e) {
            System.err.println(("File not open" + e.toString()));
            System.exit(1);
        }
    }

    public String readline() throws Exception {   //读取一行进入
        String line ="";
        line = in.readLine();
        return line;
    }

    public void shifter(String line,ArrayList<String> list) {//对每一行进行处理，将处理后的结果存在集合里

        StringTokenizer tokener = new StringTokenizer(line);
        String token = new String();
        int index;
        ArrayList<String> tokens = new ArrayList<String>();
        int count = tokener.countTokens();//计算每一行有多少个单词
        for (int j= 0; j< count; j++) {//将一行解析，并且将解析的word加入ArrayList中
            token = tokener.nextToken();
            tokens.add(token);//对每一行先读取正常输出
        }
        //对ArrayList中的字进行循环移位，得出最后结果
        for (int i = 0; i < count; i++) {
            index=i;
            StringBuffer linebuffer = new StringBuffer();
            for (int j=0; j < count; j++) {
                if (index >= count)
                    index = 0;
                linebuffer.append ( tokens.get(index)  );
                linebuffer.append (" ");
                index++;
            }
            line = linebuffer.toString();
            wordList.add(line);//移位后结果输出
        }
    }

    public void Alph(ArrayList<String> List) { //排序函数,使用Comparator接口
        List.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public void display(ArrayList<String> List) {
        for (String s : List) {
            System.out.println(s);
        }
    }

    public void write(ArrayList<String> List,String file) {
        try {
            out= new BufferedWriter(new FileWriter(file));
            for (int count=0; count< List.size();count++) {
                out.write(List.get(count) );//每行写入文件
                out.newLine();//读取下一行
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception //主程序
    {
        new Batch("E:\\TestUse\\in.txt");
    }
}