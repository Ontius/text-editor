package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.utility.TextUtil;
import org.junit.Assert;
import org.junit.Test;

public class ChangeCommandUnitTest {

    @Test
    public void whenNameIsRetrieved_thenNameIsCorrectlyRetrieved() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String name = changeCommand.getName();

        // Then
        Assert.assertEquals("change", name);
    }

    @Test
    public void whenDescriptionIsRetrieved_thenDescriptionIsCorrectlyRetrieved() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String description = changeCommand.getDescription();

        // Then
        Assert.assertEquals("Replaces a text by another text.", description);
    }

    @Test
    public void whenHelpTextIsRetrieved_thenHelpTextIsCorrectlyRetrieved() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String helpText = changeCommand.getHelpText();

        // Then
        Assert.assertEquals("CHANGE [paragraph_index] [\"search\"] [\"replacement\"] This command replaces a text by another text.", helpText);
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
        Assert.assertEquals(false, result);
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
        Assert.assertEquals(true, result);
    }

    @Test
    public void whenIsValidIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String arguments = String.format("\"%s\"", TextUtil.getShortParagraph());
        boolean result = changeCommand.execute(arguments);

        // Then
        Assert.assertEquals(false, result);
    }

    @Test(expected = RuntimeException.class)
    public void whenExecuteIsCalledWithOutOfBoundsParagraphIndex_thenExceptionIsThrown() {
        // When
        ChangeCommand changeCommand = new ChangeCommand();
        String arguments = String.format("%s \"%s\" \"%s\"", 39, TextUtil.getShortParagraph(), TextUtil.getLoremIpsumParagraph());
        changeCommand.execute(arguments);
    }

}
