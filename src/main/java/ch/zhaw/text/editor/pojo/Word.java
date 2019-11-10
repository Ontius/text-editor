package ch.zhaw.text.editor.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The word class represents a single word in the word dictionary.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class Word {

    /**
     * The word.
     */
    private String word;

    /**
     * The total number of occurrences.
     */
    private int totalNumber;

    /**
     * The number of occurrences of the word in each paragraph.
     */
    private Map<Integer, Integer> paragraphOccurrences;

    /**
     * Creates a {@link Word} object instance with the given {@code word}.
     *
     * @param word The word that is being set.
     */
    public Word(String word) {
        this.word = word;

        totalNumber = 0;
        paragraphOccurrences = new HashMap<>();
    }

    /**
     * Returns the total number of occurrences.
     *
     * @return The total number of occurrences.
     */
    public int getTotalNumber() {
        return totalNumber;
    }

    /**
     * Sets the total number of occurrences.
     *
     * @param totalNumber The total number of occurrences.
     */
    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * Returns the paragraph occurrences.
     *
     * @return The paragraph occurrences.
     */
    public Map<Integer, Integer> getParagraphOccurrences() {
        return paragraphOccurrences;
    }

    /**
     * Adds an occurrence of the word to the given {@code paragraph}.
     *
     * @param paragraph The paragraph index.
     */
    public void addOccurrenceInParagraph(int paragraph) {
        int occurrences = 1;

        if(paragraphOccurrences.containsKey(paragraph)) {
            occurrences += paragraphOccurrences.get(paragraph);
        }

        paragraphOccurrences.put(paragraph, occurrences);
        totalNumber++;
    }

    /**
     * Returns the string representation of the word.
     *
     * @return The string representation of the word.
     */
    public String getStringRepresentation() {
        List<String> paragraphList = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : paragraphOccurrences.entrySet()) {
            paragraphList.add("P(" + entry.getKey() + ")=" + entry.getValue());
        }

        String paragraphInfo = String.join(", ", paragraphList);
        return word + " (" + totalNumber + ") => " + paragraphInfo;
    }
}
