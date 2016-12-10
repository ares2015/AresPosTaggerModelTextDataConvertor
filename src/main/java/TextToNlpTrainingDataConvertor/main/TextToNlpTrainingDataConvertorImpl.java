package TextToNlpTrainingDataConvertor.main;

import TextToNlpTrainingDataConvertor.preprocessing.SentencePreprocessorImpl;
import TextToNlpTrainingDataConvertor.preprocessing.SentencesPreprocessor;
import TextToNlpTrainingDataConvertor.reader.TextReader;
import TextToNlpTrainingDataConvertor.reader.TextReaderImpl;
import TextToNlpTrainingDataConvertor.tokenizing.Tokenizer;
import TextToNlpTrainingDataConvertor.tokenizing.TokenizerImpl;
import TextToNlpTrainingDataConvertor.writer.ConvertedTextFileWriter;
import TextToNlpTrainingDataConvertor.writer.ConvertedTextFileWriterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver on 12/3/2016.
 */
public class TextToNlpTrainingDataConvertorImpl implements TextToNlpTrainingDataConvertor {

    private TextReader textReader;

    private SentencesPreprocessor sentencesPreprocessor;

    private ConvertedTextFileWriter convertedTextFileWriter;

    public TextToNlpTrainingDataConvertorImpl(TextReader textReader, SentencesPreprocessor sentencesPreprocessor,
                                              ConvertedTextFileWriter convertedTextFileWriter) {
        this.textReader = textReader;
        this.sentencesPreprocessor = sentencesPreprocessor;
        this.convertedTextFileWriter = convertedTextFileWriter;
    }

    public static void main(String[] args) {
        TextReader textReader = new TextReaderImpl();
        Tokenizer tokenizer = new TokenizerImpl();
        SentencesPreprocessor sentencesPreprocessor = new SentencePreprocessorImpl(tokenizer);
        ConvertedTextFileWriter convertedTextFileWriter = new ConvertedTextFileWriterImpl();
        TextToNlpTrainingDataConvertor textToNlpTrainingDataConvertor = new TextToNlpTrainingDataConvertorImpl(textReader,
                sentencesPreprocessor, convertedTextFileWriter);
        textToNlpTrainingDataConvertor.convert();
    }

    public void convert() {
        List<String> sentences = textReader.readText();
        List<String> preprocessedSentences = sentencesPreprocessor.preprocess(sentences);
        convertedTextFileWriter.write(preprocessedSentences);
    }

}