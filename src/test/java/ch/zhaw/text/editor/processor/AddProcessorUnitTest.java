package ch.zhaw.text.editor.processor;

import ch.zhaw.text.editor.context.AddContext;
import org.junit.Test;

public class AddProcessorUnitTest {

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
