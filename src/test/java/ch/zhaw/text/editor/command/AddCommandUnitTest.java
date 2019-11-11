package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.storage.Storage;
import ch.zhaw.text.editor.utility.TextUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddCommandUnitTest {

    /**
     * Clears the storage before every test.
     */
    @Before
    public void setUp() {
        Storage.getInstance().clear();
    }

    @Test
    public void whenNameIsRetrieved_thenNameIsCorrectlyRetrieved() {
        // When
        AddCommand addCommand = new AddCommand();
        String name = addCommand.getName();

        // Then
        assertEquals("add", name);
    }

    @Test
    public void whenDescriptionIsRetrieved_thenDescriptionIsCorrectlyRetrieved() {
        // When
        AddCommand addCommand = new AddCommand();
        String description = addCommand.getDescription();

        // Then
        assertEquals("Adds a text to the storage.", description);
    }

    @Test
    public void whenHelpTextIsRetrieved_thenHelpTextIsCorrectlyRetrieved() {
        // When
        AddCommand addCommand = new AddCommand();
        String helpText = addCommand.getHelpText();

        // Then
        assertEquals("ADD [paragraph_index] [\"content\"] This command adds a text to the editor.", helpText);
    }

    @Test
    public void whenExecuteIsCalledWithValidArguments_thenNoExceptions() {
        // When & then
        AddCommand addCommand = new AddCommand();
        String arguments = String.format("%s \"%s\"", 12, TextUtil.getShortParagraph());
        addCommand.execute(arguments);
    }

    @Test
    public void whenExecuteIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        AddCommand addCommand = new AddCommand();
        String arguments = String.format("\"%s\"", TextUtil.getShortParagraph());
        boolean result = addCommand.execute(arguments);

        // Then
        assertEquals(false, result);
    }

    @Test
    public void whenIsValidIsCalledWithValidArguments_thenReturnValueIsTrue() {
        // When
        AddCommand addCommand = new AddCommand();
        String arguments = String.format("%s \"%s\"", 19, TextUtil.getShortParagraph());
        boolean result = addCommand.execute(arguments);

        // Then
        assertEquals(true, result);
    }

    @Test
    public void whenIsValidIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        AddCommand addCommand = new AddCommand();
        String arguments = String.format("\"%s\"", TextUtil.getShortParagraph());
        boolean result = addCommand.execute(arguments);

        // Then
        assertEquals(false, result);
    }

    @Test
    public void whenExecuteIsCalledWithValidArguments_thenStorageContainsCorrectValue() {
        // When
        int paragraphIndex = 12;
        String content = TextUtil.getShortParagraph();
        AddCommand addCommand = new AddCommand();
        String arguments = String.format("%s \"%s\"", paragraphIndex, content);
        addCommand.execute(arguments);

        Storage storage = Storage.getInstance();
        String value = storage.getParagraph(paragraphIndex);

        // Then
        assertEquals(content, value);
    }

    @Test
    public void whenExecuteIsCalledTwiceWithSameParagraphIndex_thenStorageContainsCorrectValue() {
        // When
        int paragraphIndex = 12;
        AddCommand addCommand = new AddCommand();
        String arguments = String.format("%s \"%s\"", paragraphIndex, TextUtil.getShortParagraph());
        addCommand.execute(arguments);
        String content = TextUtil.getLoremIpsumParagraph();
        arguments = String.format("%s \"%s\"", paragraphIndex, content);
        addCommand.execute(arguments);

        Storage storage = Storage.getInstance();
        String value = storage.getParagraph(paragraphIndex);

        // Then
        assertEquals(content, value);
    }

}
