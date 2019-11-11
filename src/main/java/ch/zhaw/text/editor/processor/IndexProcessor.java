package ch.zhaw.text.editor.processor;

import ch.zhaw.text.editor.context.IndexContext;
import ch.zhaw.text.editor.pojo.Word;
import ch.zhaw.text.editor.pojo.WordDictionary;
import ch.zhaw.text.editor.storage.Storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The add processor class is responsible to add content to the storage.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class IndexProcessor {

    /**
     * The {@link Storage} object instance.
     */
    private Storage storage;

    /**
     * Creates an {@link IndexProcessor} object instance with the storage object instance.
     */
    public IndexProcessor() {
        storage = Storage.getInstance();
    }

    /**
     * Prints out an index of the storage.
     *
     * @param context The context holding information about the operation.
     * @return A boolean state containing information about whether the process was successful or not.
     */
    public boolean execute(IndexContext context) {
        WordDictionary wordDictionary = getWordDictionary();
        Map<String, Word> words = wordDictionary.getWords(context.getMinOccurrence());

        System.out.println("-------------- Index ---------------");

        for(Map.Entry<String, Word> entry : words.entrySet()) {
            System.out.println(entry.getValue().getStringRepresentation());
        }

        return true;
    }

    /**
     * Returns the word dictionary.
     *
     * @return A {@link WordDictionary} object instance.
     */
    public WordDictionary getWordDictionary() {
        WordDictionary wordDictionary = new WordDictionary();
        Map<Integer, String> map = storage.getParagraphMap();

        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            String paragraph = entry.getValue();
            String[] words = paragraph.replaceAll("\\s+", " ").split(" ");

            for(String word : words) {
                wordDictionary.addWord(word, entry.getKey());
            }
        }

        return wordDictionary;
    }

}
