package TextToNlpTrainingDataConvertor.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Oliver on 12/10/2016.
 */
public class ConvertedTextFileWriterImpl implements ConvertedTextFileWriter {

    private static final String FILENAME = "C:\\Users\\Oliver\\Documents\\NlpTrainingData\\AresPosTaggerModelData\\TaggerRawTextData.txt";

    public void write(List<String> sentences) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            for (String sentence : sentences) {
                bw.write(sentence);
                bw.newLine();
            }
            System.out.println("Writing into file finished");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}