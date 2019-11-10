package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.utility.TextUtil;
import org.junit.Assert;
import org.junit.Test;

public class AddCommandUnitTest {

    @Test
    public void whenNameIsRetrieved_thenNameIsCorrectlyRetrieved() {
        // When
        AddCommand addCommand = new AddCommand();
        String name = addCommand.getName();

        // Then
        Assert.assertEquals("add", name);
    }

    @Test
    public void whenDescriptionIsRetrieved_thenDescriptionIsCorrectlyRetrieved() {
        // When
        AddCommand addCommand = new AddCommand();
        String description = addCommand.getDescription();

        // Then
        Assert.assertEquals("Adds a text to the storage.", description);
    }

    @Test
    public void whenHelpTextIsRetrieved_thenHelpTextIsCorrectlyRetrieved() {
        // When
        AddCommand addCommand = new AddCommand();
        String helpText = addCommand.getHelpText();

        // Then
        Assert.assertEquals("ADD [paragraph_index] [\"content\"] This command adds a text to the editor.", helpText);
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
        Assert.assertEquals(false, result);
    }

    @Test
    public void whenIsValidIsCalledWithValidArguments_thenReturnValueIsTrue() {
        // When
        AddCommand addCommand = new AddCommand();
        String arguments = String.format("%s \"%s\"", 19, TextUtil.getShortParagraph());
        boolean result = addCommand.execute(arguments);

        // Then
        Assert.assertEquals(true, result);
    }

    @Test
    public void whenIsValidIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        AddCommand addCommand = new AddCommand();
        String arguments = String.format("\"%s\"", TextUtil.getShortParagraph());
        boolean result = addCommand.execute(arguments);

        // Then
        Assert.assertEquals(false, result);
    }

}
