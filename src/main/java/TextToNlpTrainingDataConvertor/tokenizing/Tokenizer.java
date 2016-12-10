package TextToNlpTrainingDataConvertor.tokenizing;

/**
 * Created by Oliver on 12/5/2016.
 */
public interface Tokenizer {

    String removeBrackets(String string, char bracket1, char bracket2);

    String removeDoubleQuotes(String string);

    String removeEmptyStrings(String string);

}
