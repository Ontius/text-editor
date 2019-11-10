package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.utility.TextUtil;
import org.junit.Assert;
import org.junit.Test;

public class IndexCommandUnitTest {

    @Test
    public void whenNameIsRetrieved_thenNameIsCorrectlyRetrieved() {
        // When
        IndexCommand indexCommand = new IndexCommand();
        String name = indexCommand.getName();

        // Then
        Assert.assertEquals("index", name);
    }

    @Test
    public void whenDescriptionIsRetrieved_thenDescriptionIsCorrectlyRetrieved() {
        // When
        IndexCommand indexCommand = new IndexCommand();
        String description = indexCommand.getDescription();

        // Then
        Assert.assertEquals("Prints out an index of all words in the storage.", description);
    }

    @Test
    public void whenHelpTextIsRetrieved_thenHelpTextIsCorrectlyRetrieved() {
        // When
        IndexCommand indexCommand = new IndexCommand();
        String helpText = indexCommand.getHelpText();

        // Then
        Assert.assertEquals("INDEX [minimal_occurrence] This command prints out an index of all words in the editor.", helpText);
    }

    @Test
    public void givenParagraphExists_whenExecuteIsCalledWithValidArguments_thenNoExceptions() {
        // Given
        AddCommand addCommand = new AddCommand();
        String addArguments = String.format("%s", 12, TextUtil.getLongParagraph());
        addCommand.execute(addArguments);

        // When & then
        IndexCommand indexCommand = new IndexCommand();
        String arguments = String.format("%s", 2);
        indexCommand.execute(arguments);
    }

    @Test
    public void whenExecuteIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        IndexCommand indexCommand = new IndexCommand();
        boolean result = indexCommand.execute("");

        // Then
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenParagraphExists_whenIsValidIsCalledWithValidArguments_thenReturnValueIsTrue() {
        // Given
        AddCommand addCommand = new AddCommand();
        String addArguments = String.format("%s \"%s\"", 29, TextUtil.getLongParagraph());
        addCommand.execute(addArguments);

        // When
        IndexCommand indexCommand = new IndexCommand();
        String arguments = String.format("%s", 2);
        boolean result = indexCommand.execute(arguments);

        // Then
        Assert.assertEquals(true, result);
    }

    @Test
    public void whenIsValidIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        IndexCommand indexCommand = new IndexCommand();
        boolean result = indexCommand.execute("");

        // Then
        Assert.assertEquals(false, result);
    }

}
