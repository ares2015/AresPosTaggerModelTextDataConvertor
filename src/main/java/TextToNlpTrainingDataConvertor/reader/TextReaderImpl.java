package TextToNlpTrainingDataConvertor.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Oliver on 12/3/2016.
 */
public class TextReaderImpl implements TextReader {

    public List<String> readText() {
        List<String> sentences = null;
        String wholeText = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Oliver\\Documents\\NlpTrainingData\\TextData.txt"));
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String testDataRow = br.readLine();
            while (testDataRow != null) {
                if(!"".equals(testDataRow)){
                    wholeText += testDataRow;
                    testDataRow += " ";
                }
                testDataRow = br.readLine();
            }
            sentences = Arrays.asList(wholeText.split("[\\.\\!\\?]"));

        } catch (final IOException e) {
            e.printStackTrace();

        }
        return sentences;
    }
}








