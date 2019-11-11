package ch.zhaw.text.editor.processor;

import ch.zhaw.text.editor.pojo.Word;
import ch.zhaw.text.editor.pojo.WordDictionary;
import ch.zhaw.text.editor.storage.Storage;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class IndexProcessorUnitTest {

    /**
     * Clears the storage before every test.
     */
    @Before
    public void setUp() {
        Storage.getInstance().clear();
    }

    @Test
    public void givenParagraphsExist_whenWordDictionaryIsRetrieved_thenResultIsCorrect() {
        // Given
        Storage storage = Storage.getInstance();
        storage.setParagraph(1, "Hello World Hello Hello");
        storage.setParagraph(2, "Hello World");

        // When
        IndexProcessor indexProcessor = new IndexProcessor();
        WordDictionary wordDictionary = indexProcessor.getWordDictionary();

        Map<String, Word> words = wordDictionary.getWords();

        assertTrue(words.containsKey("hello"));
        assertTrue(words.containsKey("world"));
        assertEquals(words.get("hello").getTotalNumber(), 4);
        assertEquals(words.get("world").getTotalNumber(), 2);

        Map<Integer, Integer> helloOccurrences = words.get("hello").getParagraphOccurrences();

        Map<Integer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(1, 3);
        expectedMap.put(2, 1);

        assertEquals(expectedMap, helloOccurrences);
    }

}
