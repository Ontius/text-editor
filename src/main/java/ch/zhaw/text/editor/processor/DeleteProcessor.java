package ch.zhaw.text.editor.processor;

import ch.zhaw.text.editor.context.DeleteContext;
import ch.zhaw.text.editor.storage.Storage;

/**
 * The add processor class is responsible to add content to the storage.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class DeleteProcessor {

    /**
     * The {@link Storage} object instance.
     */
    private Storage storage;

    /**
     * Creates an {@link DeleteProcessor} object instance with the storage object instance.
     */
    public DeleteProcessor() {
        storage = Storage.getInstance();
    }

    /**
     * Adds content to the storage.
     *
     * @param context The context holding information about the operation.
     * @return A boolean state containing information about whether the process was successful or not.
     */
    public boolean execute(DeleteContext context) {
        storage.deleteParagraph(context.getParagraphIndex());

        return true;
    }

}
