package ch.zhaw.text.editor.context;

/**
 * The delete context class is responsible for holding information about an delete operation.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class DeleteContext {

    /**
     * The index of the paragraph.
     */
    private int paragraphIndex;

    /**
     * The default constructor.
     */
    public DeleteContext() {
    }

    /**
     * Creates an {@link DeleteContext} object instance with the given {@code paragraphIndex}.
     *
     * @param paragraphIndex The paragraph index that is being set.
     */
    public DeleteContext(int paragraphIndex) {
        this.paragraphIndex = paragraphIndex;
    }

    /**
     * Returns the paragraph index.
     *
     * @return The paragraph index.
     */
    public int getParagraphIndex() {
        return paragraphIndex;
    }

    /**
     * Sets the paragraph index.
     *
     * @param paragraphIndex The paragraph index that is being set.
     */
    public void setParagraphIndex(int paragraphIndex) {
        this.paragraphIndex = paragraphIndex;
    }
}
