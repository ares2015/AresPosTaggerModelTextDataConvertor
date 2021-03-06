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
    public void testRemoveSpecialCharacters() {
        assertEquals("dog's", tokenizer.removeSpecialCharacters("dog's_*"));
        assertEquals("I've", tokenizer.removeSpecialCharacters("I've"));
    }

    @Test
    public void testRemoveTextReferenceBrackets() {
        String testString = "[22][23]abc def";
        assertEquals("abc def", tokenizer.removeBrackets(testString, '[', ']'));
    }

    @Test
    public void testRemoveNestedSentenceBrackets() {
        String testString = "ab (c) d";
        assertEquals("ab  d", tokenizer.removeBrackets(testString, '(', ')'));
    }

    @Test
    public void testRemoveDoubleQuotes() {
        System.out.println("\"king's ships\"");
        assertEquals("king's ships", tokenizer.removeDoubleQuotes("\"king's ships\""));
        System.out.println(tokenizer.removeDoubleQuotes("\"king's ships\""));
    }

    @Test
    public void testRemoveEmptyStrings() {
        assertEquals("a bc d e", tokenizer.removeEmptyStrings("a   bc  d e"));
        System.out.println(tokenizer.removeEmptyStrings("a   bc  d e"));
//        assertEquals("bob dylan and bryan drink beer", tokenizer.removeEmptyStrings("bob\u0000 dylan and bryan drink beer"));
        System.out.println(tokenizer.removeEmptyStrings("bob\u0000 dylan and bryan drink beer"));
    }

}