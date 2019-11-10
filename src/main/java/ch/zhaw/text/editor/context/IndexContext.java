package ch.zhaw.text.editor.context;

/**
 * The index context class is responsible for holding information about an index operation.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class IndexContext {

    /**
     * The minimal occurrence of a word.
     */
    private int minOccurrence;

    /**
     * The default constructor.
     */
    public IndexContext() {
    }

    /**
     * Creates an {@link IndexContext} object instance with the given {@code minOccurrence}.
     *
     * @param minOccurrence The minimal occurrence that is being set.
     */
    public IndexContext(int minOccurrence) {
        this.minOccurrence = minOccurrence;
    }

    /**
     * Returns the minimal occurrence.
     *
     * @return The minimal occurrence.
     */
    public int getMinOccurrence() {
        return minOccurrence;
    }

    /**
     * Sets the minimal occurrence.
     *
     * @param minOccurrence The minimal occurrence that is being set.
     */
    public void setMinOccurrence(int minOccurrence) {
        this.minOccurrence = minOccurrence;
    }
}
