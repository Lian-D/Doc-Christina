import function.FileUpdateCheck;
import function.Filereader;
import function.StringParse;

import java.io.File;
import java.io.IOException;


public class Test {

    public static void main(String[] args){
        System.out.println("Hello World");
        Filereader filereader = new Filereader();
        try {
            String text = filereader.readFile("speechdata.txt");
            System.out.println(text);
            StringParse parser = new StringParse();
            parser.transcribedData = text;
            System.out.println(new FileUpdateCheck().isFileUpdated(new File("speechdata.txt")));
            parser.parseData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
