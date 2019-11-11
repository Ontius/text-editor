package ch.zhaw.text.editor.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The storage class is responsible to store all the paragraphs.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class Storage {

    /**
     * The single {@link Storage} object instance.
     */
    private static Storage instance;

    /**
     * The list of paragraphs.
     */
    private List<String> paragraphs;

    /**
     * Creates a {@link Storage} object instance with an empty paragraph list.
     */
    private Storage() {
        paragraphs = new ArrayList<>();
    }

    /**
     * Returns the {@link Storage} object instance. There should be only one storage. So this method has to be used
     * to get the storage instance.
     *
     * @return The {@link Storage} object instance.
     */
    public static Storage getInstance() {
        if(instance == null) {
            instance = new Storage();
        }

        return instance;
    }

    /**
     * Sets a paragraph. It is possible to add a paragraph e.g. on line 12,
     * if there are not enough lines, the method will fill up those lines with
     * empty strings.
     *
     * @param index The paragraph index. This value should be at least 1. So the index should be in a human readable format.
     * @param content The content of the paragraph.
     * @throws RuntimeException If the index is less or equals 0.
     */
    public void setParagraph(int index, String content) {
        if(index <= 0) {
            String message = String.format("The index '%s' in not allowed.", index);
            throw new RuntimeException(message);
        }

        int listIndex = convertIndexToListIndex(index);

        if((listIndex) < paragraphs.size()) {
            paragraphs.set(listIndex, content);
        } else {
            for(int i = paragraphs.size(); i < index; i++) {
                if(i == (listIndex)) {
                    paragraphs.add(content);
                } else {
                    paragraphs.add("");
                }
            }
        }
    }

    /**
     * Returns a paragraph at the given {@code index}. The index should be at least 1.
     *
     * @param index The paragraph index. This value should be at least 1. So the index should be in a human readable format.
     * @return The content of the paragraph.
     * @throws RuntimeException If the index is out of bounds.
     */
    public String getParagraph(int index) {
        if(index <= 0 || index > paragraphs.size()) {
            String message = String.format("The index '%s' is out of bounds.", index);
            throw new RuntimeException(message);
        }

        int listIndex = convertIndexToListIndex(index);
        return paragraphs.get(listIndex);
    }

    /**
     * Returns a paragraph map.
     *
     * @return A paragraph map.
     */
    public Map<Integer, String> getParagraphMap() {
        Map<Integer, String> map = new HashMap<>();

        for(int i = 0; i < paragraphs.size(); i++) {
            map.put(i + 1, paragraphs.get(i));
        }

        return map;
    }

    /**
     * Deletes the paragraph at the given {@code index}.
     *
     * @param index The paragraph index. This value should be at least 1. So the index should be in a human readable format.
     * @throws RuntimeException If the index is out of bounds.
     */
    public void deleteParagraph(int index) {
        if(index <= 0 || index > paragraphs.size()) {
            String message = String.format("The index '%s' is out of bounds.", index);
            throw new RuntimeException(message);
        }

        int listIndex = convertIndexToListIndex(index);
        paragraphs.remove(listIndex);
    }

    /**
     * Clears the whole storage.
     */
    public void clear() {
        paragraphs.clear();
    }

    /**
     * Converts the given {@code index} to a list index.
     *
     * @param index The index that is being converted.
     * @return The converted index.
     */
    private int convertIndexToListIndex(int index) {
        return index - 1;
    }

}
