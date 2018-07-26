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
public class AresPosTaggerModelTextDataConvertorImpl implements AresPosTaggerModelTextDataConvertor {

    private TextReader textReader;

    private SentencesPreprocessor sentencesPreprocessor;

    private ConvertedTextFileWriter convertedTextFileWriter;

    public AresPosTaggerModelTextDataConvertorImpl(TextReader textReader, SentencesPreprocessor sentencesPreprocessor,
                                                   ConvertedTextFileWriter convertedTextFileWriter) {
        this.textReader = textReader;
        this.sentencesPreprocessor = sentencesPreprocessor;
        this.convertedTextFileWriter = convertedTextFileWriter;
    }

    public static void main(String[] args) {
//        System.setProperty("file.encoding","UTF-8");
        TextReader textReader = new TextReaderImpl();
        Tokenizer tokenizer = new TokenizerImpl();
        SentencesPreprocessor sentencesPreprocessor = new SentencePreprocessorImpl(tokenizer);
        ConvertedTextFileWriter convertedTextFileWriter = new ConvertedTextFileWriterImpl();
        AresPosTaggerModelTextDataConvertor aresPosTaggerModelTextDataConvertor = new AresPosTaggerModelTextDataConvertorImpl(textReader,
                sentencesPreprocessor, convertedTextFileWriter);
        aresPosTaggerModelTextDataConvertor.convert();
    }

    public void convert() {
        List<String> sentences = textReader.readText();
        List<String> preprocessedSentences = new ArrayList<>();
        for (String sentence : sentences) {
            String preprocessedSentence = sentencesPreprocessor.preprocess(sentence);
            preprocessedSentences.add(preprocessedSentence);
        }
        convertedTextFileWriter.write(preprocessedSentences);
    }

}