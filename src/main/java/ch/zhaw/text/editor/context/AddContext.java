package ch.zhaw.text.editor.context;

/**
 * The add context class is responsible for holding information about an add operation.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class AddContext {

    /**
     * The index of the paragraph.
     */
    private int paragraphIndex;

    /**
     * The content of the paragraph.
     */
    private String content;

    /**
     * The default constructor.
     */
    public AddContext() {
    }

    /**
     * Creates an {@link AddContext} object instance with the given {@code paragraphIndex} and {@code content}.
     *
     * @param paragraphIndex The paragraph index that is being set.
     * @param content The content that is being set.
     */
    public AddContext(int paragraphIndex, String content) {
        this.paragraphIndex = paragraphIndex;
        this.content = content;
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

    /**
     * Returns the paragraph content.
     *
     * @return The paragraph content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the paragraph content.
     *
     * @param content The paragraph content that is being set.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
