package ch.zhaw.text.editor.processor;

import ch.zhaw.text.editor.context.AddContext;
import ch.zhaw.text.editor.storage.Storage;
import org.junit.Before;
import org.junit.Test;

public class AddProcessorUnitTest {

    /**
     * Clears the storage before every test.
     */
    @Before
    public void setUp() {
        Storage.getInstance().clear();
    }

    @Test
    public void whenParagraphIsAdded_thenNoException() {
        // When & then
        AddContext context = new AddContext();
        AddProcessor addProcessor = new AddProcessor();

        context.setParagraphIndex(1);
        context.setContent("Coding is fun");

        addProcessor.execute(context);
    }

}
