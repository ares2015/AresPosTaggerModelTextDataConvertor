package TextToNlpTrainingDataConvertor.writer;

import java.util.List;

/**
 * Created by Oliver on 12/10/2016.
 */
public interface ConvertedTextFileWriter {

    void write(List<String> sentences);

}
