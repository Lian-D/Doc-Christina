package function;

import java.util.ArrayList;
import java.util.List;


public class StringParse {
    public String transcribedData;

    public String parseData() {
        String json = transcribedData;
        List<String> extracteddata = new ArrayList<>();
        String parts[] = json.split("'");
        String transcriptExtract = parts[9];

        transcriptExtract = transcriptExtract.replaceAll("\"", "").trim();
        System.out.println("you said: " + transcriptExtract);

        return transcriptExtract;

    }
}
