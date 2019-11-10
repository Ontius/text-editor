package ch.zhaw.text.editor.context;

/**
 * The change context class is responsible for holding information about change operation.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class ChangeContext {

    /**
     * The index of the paragraph.
     */
    private int paragraphIndex;

    /**
     * The search string.
     */
    private String search;

    /**
     * The replacement string.
     */
    private String replacement;

    /**
     * The default constructor.
     */
    public ChangeContext() {
    }

    /**
     * Creates an {@link ChangeContext} object instance with the given {@code paragraphIndex} and {@code content}.
     *
     * @param paragraphIndex The paragraph index that is being set.
     * @param search The search string that is being set.
     * @param replacement The replacement string that is being set.
     */
    public ChangeContext(int paragraphIndex, String search, String replacement) {
        this.paragraphIndex = paragraphIndex;
        this.search = search;
        this.replacement = replacement;
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
     * Returns the search string.
     *
     * @return The search string.
     */
    public String getSearch() {
        return search;
    }

    /**
     * Sets the search string.
     *
     * @param search The search string that is being set.
     */
    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * Returns the replacement string.
     *
     * @return The replacement string.
     */
    public String getReplacement() {
        return replacement;
    }

    /**
     * Sets the replacement string.
     *
     * @param replacement The replacement string that is being set.
     */
    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }
}
