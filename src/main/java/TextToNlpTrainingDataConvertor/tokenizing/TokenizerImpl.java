package TextToNlpTrainingDataConvertor.tokenizing;

/**
 * Created by Oliver on 12/10/2016.
 */
public class TokenizerImpl implements Tokenizer {

    public String removeBrackets(String token, char bracket1, char bracket2) {
        StringBuilder filteredSentence = new StringBuilder();
        char[] chars = token.toCharArray();
        boolean isNestedSequence = false;
        for (int i = 0; i < chars.length; i++) {
            if (bracket1 == chars[i]) {
                isNestedSequence = true;
            } else if (bracket2 == chars[i]) {
                isNestedSequence = false;
            }
            else if (bracket1 != chars[i] && !isNestedSequence) {
                filteredSentence.append(String.valueOf(chars[i]));
            }
        }
        return filteredSentence.toString();
    }


}
