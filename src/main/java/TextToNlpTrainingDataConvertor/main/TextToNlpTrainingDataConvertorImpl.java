package TextToNlpTrainingDataConvertor.main;

import TextToNlpTrainingDataConvertor.preprocessing.SentencePreprocessorImpl;
import TextToNlpTrainingDataConvertor.preprocessing.SentencesPreprocessor;
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

    private SentencesPreprocessor sentencesPreprocessor;

    public TextToNlpTrainingDataConvertorImpl(TextReader textReader, SentencesPreprocessor sentencesPreprocessor) {
        this.textReader = textReader;
        this.sentencesPreprocessor = sentencesPreprocessor;
    }

    public static void main(String[] args) {
        TextReader textReader = new TextReaderImpl();
        Tokenizer tokenizer = new TokenizerImpl();
        SentencesPreprocessor sentencesPreprocessor = new SentencePreprocessorImpl(tokenizer);
        TextToNlpTrainingDataConvertor textToNlpTrainingDataConvertor = new TextToNlpTrainingDataConvertorImpl(textReader, sentencesPreprocessor);

        textToNlpTrainingDataConvertor.convert();
    }

    public void convert() {
        List<String> sentences = textReader.readText();
        sentencesPreprocessor.preprocess(sentences);
    }


}