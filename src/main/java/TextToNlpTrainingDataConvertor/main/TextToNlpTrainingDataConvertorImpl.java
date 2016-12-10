package TextToNlpTrainingDataConvertor.main;

import TextToNlpTrainingDataConvertor.reader.TextReader;
import TextToNlpTrainingDataConvertor.reader.TextReaderImpl;
import TextToNlpTrainingDataConvertor.tokenizing.Tokenizer;
import TextToNlpTrainingDataConvertor.tokenizing.TokenizerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver on 12/3/2016.
 */
public class TextToNlpTrainingDataConvertorImpl implements TextToNlpTrainingDataConvertor {

    private TextReader textReader;

    private Tokenizer tokenizer;

    public TextToNlpTrainingDataConvertorImpl(TextReader textReader, Tokenizer tokenizer) {
        this.textReader = textReader;
        this.tokenizer = tokenizer;
    }

    public static void main(String[] args) {
        TextReader textReader = new TextReaderImpl();
        Tokenizer tokenizer = new TokenizerImpl();
        TextToNlpTrainingDataConvertor textToNlpTrainingDataConvertor = new TextToNlpTrainingDataConvertorImpl(textReader, tokenizer);
        textToNlpTrainingDataConvertor.convert();
    }

    public void convert() {
        List<String> processedSentences = new ArrayList<String>();
        List<String> sentences = textReader.readText();
        for (String sentence : sentences) {
            if (sentence.contains("(")) {
                sentence = tokenizer.removeBrackets(sentence, '(', ')');
            }
            if (sentence.contains("[")) {
                sentence = tokenizer.removeBrackets(sentence, '[', ']');
            }
            System.out.println(sentence);
        }
    }

}