package TextToNlpTrainingDataConvertor;

import TextToNlpTrainingDataConvertor.tokenizing.Tokenizer;
import TextToNlpTrainingDataConvertor.tokenizing.TokenizerImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 12/10/2016.
 */
public class TokenizerTest {

    Tokenizer tokenizer = new TokenizerImpl();

    @Test
    public void testRemoveTextReferenceBrackets() {
        String testString = "[22][23]abc def";
        assertEquals("abc def", tokenizer.removeBrackets(testString, '[', ']'));
    }

    @Test
    public void testRemoveNestedSentenceBrackets(){
        String testString = "ab (c) d";
        assertEquals("ab  d", tokenizer.removeBrackets(testString, '(', ')'));
    }
}