package TextToNlpTrainingDataConvertor.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Oliver on 12/3/2016.
 */
public class TextReaderImpl implements TextReader {

    public List<String> readText() {
        List<String> sentences = new ArrayList<String>();
        try {
            File file = new File("C:\\Users\\Oliver\\Documents\\NlpTrainingData\\TextData.txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("[.?!]");
            while (scanner.hasNext()) {
                String sentence = scanner.next();
                sentence = sentence.replaceAll("\\r?\\n", " ");
                // uncomment for nicer output
                sentence = sentence.trim();
                sentences.add(sentence);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sentences;
    }
}
