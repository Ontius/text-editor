package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.storage.Storage;
import ch.zhaw.text.editor.utility.TextUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeCommandUnitTest {

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
        ChangeCommand changeCommand = new ChangeCommand();
        String name = changeCommand.getName();

        // Then
        assertEquals("change", name);
    }

    @Test
    public void whenDescriptionIsRetrieved_thenDescriptionIsCorrectlyRetrieved() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String description = changeCommand.getDescription();

        // Then
        assertEquals("Replaces a text by another text.", description);
    }

    @Test
    public void whenHelpTextIsRetrieved_thenHelpTextIsCorrectlyRetrieved() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String helpText = changeCommand.getHelpText();

        // Then
        assertEquals("CHANGE [paragraph_index] [\"search\"] [\"replacement\"] This command replaces a text by another text.", helpText);
    }

    @Test
    public void givenParagraphExists_whenExecuteIsCalledWithValidArguments_thenNoExceptions() {
        // Given
        AddCommand addCommand = new AddCommand();
        String addArguments = String.format("%s \"%s\"", 12, TextUtil.getShortParagraph());
        addCommand.execute(addArguments);

        // When & then
        ChangeCommand changeCommand = new ChangeCommand();
        String arguments = String.format("%s \"%s\" \"%s\"", 12, TextUtil.getShortParagraph(), TextUtil.getLoremIpsumParagraph());
        changeCommand.execute(arguments);
    }

    @Test
    public void whenExecuteIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String arguments = String.format("\"%s\"", TextUtil.getShortParagraph());
        boolean result = changeCommand.execute(arguments);

        // Then
        assertEquals(false, result);
    }

    @Test
    public void givenParagraphExists_whenIsValidIsCalledWithValidArguments_thenReturnValueIsTrue() {
        // Given
        AddCommand addCommand = new AddCommand();
        String addArguments = String.format("%s \"%s\"", 29, TextUtil.getShortParagraph());
        addCommand.execute(addArguments);

        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String arguments = String.format("%s \"%s\" \"%s\"", 29, TextUtil.getShortParagraph(), TextUtil.getLoremIpsumParagraph());
        boolean result = changeCommand.execute(arguments);

        // Then
        assertEquals(true, result);
    }

    @Test
    public void whenIsValidIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String arguments = String.format("\"%s\"", TextUtil.getShortParagraph());
        boolean result = changeCommand.execute(arguments);

        // Then
        assertEquals(false, result);
    }

    @Test(expected = RuntimeException.class)
    public void whenExecuteIsCalledWithOutOfBoundsParagraphIndex_thenExceptionIsThrown() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String arguments = String.format("%s \"%s\" \"%s\"", 39, TextUtil.getShortParagraph(), TextUtil.getLoremIpsumParagraph());
        changeCommand.execute(arguments);
    }

    @Test
    public void givenParagraphExists_whenExecuteIsCalledWithValidArguments_thenStorageContainsCorrectValue() {
        // Given
        int paragraphIndex = 12;
        AddCommand addCommand = new AddCommand();
        String arguments = String.format("%s \"%s\"", paragraphIndex, "Coding is fun");
        addCommand.execute(arguments);

        // When
        ChangeCommand changeCommand = new ChangeCommand();
        arguments = String.format("%s \"%s\" \"%s\"", paragraphIndex, "fun", "interesting");
        changeCommand.execute(arguments);

        Storage storage = Storage.getInstance();
        String value = storage.getParagraph(paragraphIndex);

        // Then
        assertEquals("Coding is interesting", value);
    }

}
