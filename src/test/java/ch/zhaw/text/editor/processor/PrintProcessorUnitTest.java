package ch.zhaw.text.editor.processor;

import ch.zhaw.text.editor.context.AddContext;
import ch.zhaw.text.editor.context.PrintContext;
import ch.zhaw.text.editor.utility.TextUtil;
import org.junit.Before;
import org.junit.Test;

public class PrintProcessorUnitTest {

    @Before
    public void setup() {
        AddContext context = new AddContext();
        AddProcessor addProcessor = new AddProcessor();

        context.setParagraphIndex(1);
        context.setContent(TextUtil.getLoremIpsumParagraph());

        addProcessor.execute(context);
    }

    @Test
    public void whenPrintTextIsCalled_thenNoException() {
        // When & then
        PrintContext context = new PrintContext();
        PrintProcessor printProcessor = new PrintProcessor();

        context.setOperation(PrintContext.Operation.TEXT);

        printProcessor.execute(context);
    }

    @Test
    public void whenPrintTextWithWidthIsCalled_thenNoException() {
        // When & then
        PrintContext context = new PrintContext();
        PrintProcessor printProcessor = new PrintProcessor();

        context.setOperation(PrintContext.Operation.WIDTH);
        context.setWidth(100);

        printProcessor.execute(context);
    }

}
