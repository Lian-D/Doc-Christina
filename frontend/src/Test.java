import function.FileUpdateCheck;
import function.Filereader;
import function.StringParse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Test {

    public static void main(String[] args){
        System.out.println("Hello World");
        Filereader filereader = new Filereader();
        try {
            String text = filereader.readFile("speechdata.txt");
            System.out.println(text);
            StringParse parser = new StringParse();
            parser.transcribedData = text;
            File file = new File("speechdata.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
