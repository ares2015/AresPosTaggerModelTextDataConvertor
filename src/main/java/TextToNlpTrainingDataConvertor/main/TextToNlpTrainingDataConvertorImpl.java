package TextToNlpTrainingDataConvertor.main;

import TextToNlpTrainingDataConvertor.reader.TextReader;
import TextToNlpTrainingDataConvertor.reader.TextReaderImpl;

import java.util.List;

/**
 * Created by Oliver on 12/3/2016.
 */
public class TextToNlpTrainingDataConvertorImpl implements TextToNlpTrainingDataConvertor {

    private TextReader textReader;

    public TextToNlpTrainingDataConvertorImpl(TextReader textReader) {
        this.textReader = textReader;
    }

    public static void main(String[] args){
        TextReader textReader = new TextReaderImpl();
        TextToNlpTrainingDataConvertor textToNlpTrainingDataConvertor = new TextToNlpTrainingDataConvertorImpl(textReader);
        textToNlpTrainingDataConvertor.convert();
    }
    public void convert() {
        List<String> sentences = textReader.readText();
        for(String sentence : sentences){
            System.out.println(sentence);
        }
    }

}