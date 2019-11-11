package ch.zhaw.text.editor.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * The word dictionary class is responsible for managing the word dictionary.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class WordDictionary {

    /**
     * The map of words.
     */
    private Map<String, Word> words;

    /**
     * The default constructor.
     */
    public WordDictionary() {
        words = new HashMap<>();
    }

    /**
     * Adds a word to the dictionary.
     *
     * @param word The word.
     * @param paragraph The index of the paragraph.
     */
    public void addWord(String word, int paragraph) {
        String lowerCaseWord = word.toLowerCase();

        if(!words.containsKey(lowerCaseWord)) {
            words.put(lowerCaseWord, new Word(lowerCaseWord));
        }

        words.get(lowerCaseWord).addOccurrenceInParagraph(paragraph);
    }

    /**
     * Returns the words.
     *
     * @return The words.
     */
    public Map<String, Word> getWords() {
        return words;
    }

    /**
     * Returns the words filtered by the given {@code minOccurrence}.
     *
     * @param minOccurrence The minimal occurrence to filter with.
     * @return The words.
     */
    public Map<String, Word> getWords(int minOccurrence) {
        Map<String, Word> filteredWords = new HashMap<>();

        for(Map.Entry<String, Word> entry : words.entrySet()) {
            Word word = entry.getValue();

            if(word.getTotalNumber() >= minOccurrence) {
                filteredWords.put(entry.getKey(), entry.getValue());
            }
        }

        return filteredWords;
    }
}
