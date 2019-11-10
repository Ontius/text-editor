package ch.zhaw.text.editor.processor;

import ch.zhaw.text.editor.context.ChangeContext;
import ch.zhaw.text.editor.storage.Storage;

/**
 * The change processor class is responsible to change content in the storage.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class ChangeProcessor {

    /**
     * The {@link Storage} object instance.
     */
    private Storage storage;

    /**
     * Creates an {@link ChangeProcessor} object instance with the storage object instance.
     */
    public ChangeProcessor() {
        storage = Storage.getInstance();
    }

    /**
     * Changes content in the storage.
     *
     * @param context The context holding information about the operation.
     * @return A boolean state containing information about whether the process was successful or not.
     */
    public boolean execute(ChangeContext context) {
        String paragraph = storage.getParagraph(context.getParagraphIndex());
        String newParagraph = paragraph.replaceAll(context.getSearch(), context.getReplacement());
        storage.setParagraph(context.getParagraphIndex(), newParagraph);

        return true;
    }

}
