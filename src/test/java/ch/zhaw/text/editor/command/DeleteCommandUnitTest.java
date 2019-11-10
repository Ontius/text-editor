package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.utility.TextUtil;
import org.junit.Assert;
import org.junit.Test;

public class DeleteCommandUnitTest {

    @Test
    public void whenNameIsRetrieved_thenNameIsCorrectlyRetrieved() {
        // When
        DeleteCommand deleteCommand = new DeleteCommand();
        String name = deleteCommand.getName();

        // Then
        Assert.assertEquals("delete", name);
    }

    @Test
    public void whenDescriptionIsRetrieved_thenDescriptionIsCorrectlyRetrieved() {
        // When
        DeleteCommand deleteCommand = new DeleteCommand();
        String description = deleteCommand.getDescription();

        // Then
        Assert.assertEquals("Deletes a text from the storage.", description);
    }

    @Test
    public void whenHelpTextIsRetrieved_thenHelpTextIsCorrectlyRetrieved() {
        // When
        DeleteCommand deleteCommand = new DeleteCommand();
        String helpText = deleteCommand.getHelpText();

        // Then
        Assert.assertEquals("DELETE [paragraph_index] This command deletes a text from the editor.", helpText);
    }

    @Test
    public void givenParagraphExists_whenExecuteIsCalledWithValidArguments_thenNoExceptions() {
        // Given
        AddCommand addCommand = new AddCommand();
        String addArguments = String.format("%s \"%s\"", 12, TextUtil.getShortParagraph());
        addCommand.execute(addArguments);

        // When & then
        DeleteCommand deleteCommand = new DeleteCommand();
        String arguments = String.format("%s", 12);
        deleteCommand.execute(arguments);
    }

    @Test
    public void whenExecuteIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        DeleteCommand deleteCommand = new DeleteCommand();
        boolean result = deleteCommand.execute("");

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
        DeleteCommand deleteCommand = new DeleteCommand();
        String arguments = String.format("%s", 29);
        boolean result = deleteCommand.execute(arguments);

        // Then
        Assert.assertEquals(true, result);
    }

    @Test
    public void whenIsValidIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        DeleteCommand deleteCommand = new DeleteCommand();
        String arguments = String.format("\"%s\"", TextUtil.getShortParagraph());
        boolean result = deleteCommand.execute(arguments);

        // Then
        Assert.assertEquals(false, result);
    }

    @Test(expected = RuntimeException.class)
    public void whenExecuteIsCalledWithOutOfBoundsParagraphIndex_thenExceptionIsThrown() {
        // When
        DeleteCommand deleteCommand = new DeleteCommand();
        String arguments = String.format("%s", 39);
        deleteCommand.execute(arguments);
    }

}
