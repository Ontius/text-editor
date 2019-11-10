package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.utility.TextUtil;
import org.junit.Assert;
import org.junit.Test;

public class PrintCommandUnitTest {

    @Test
    public void whenNameIsRetrieved_thenNameIsCorrectlyRetrieved() {
        // When
        PrintCommand printCommand = new PrintCommand();
        String name = printCommand.getName();

        // Then
        Assert.assertEquals("print", name);
    }

    @Test
    public void whenDescriptionIsRetrieved_thenDescriptionIsCorrectlyRetrieved() {
        // When
        PrintCommand printCommand = new PrintCommand();
        String description = printCommand.getDescription();

        // Then
        Assert.assertEquals("Prints text to the console.", description);
    }

    @Test
    public void whenHelpTextIsRetrieved_thenHelpTextIsCorrectlyRetrieved() {
        // When
        PrintCommand printCommand = new PrintCommand();
        String helpText = printCommand.getHelpText();

        // Then
        Assert.assertEquals("PRINT [TEXT|WIDTH] [width_value] This command prints text to the console.", helpText);
    }

    @Test
    public void givenParagraphExists_whenExecuteIsCalledWithTextOperation_thenNoExceptions() {
        // Given
        AddCommand addCommand = new AddCommand();
        String addArguments = String.format("%s", 12, TextUtil.getLongParagraph());
        addCommand.execute(addArguments);

        // When & then
        PrintCommand printCommand = new PrintCommand();
        printCommand.execute("TEXT");
        String arguments = String.format("WIDTH %s", 90);
        printCommand.execute(arguments);
    }

    @Test
    public void givenParagraphExists_whenExecuteIsCalledWithWidthOperation_thenNoExceptions() {
        // Given
        AddCommand addCommand = new AddCommand();
        String addArguments = String.format("%s", 12, TextUtil.getLongParagraph());
        addCommand.execute(addArguments);

        // When & then
        PrintCommand printCommand = new PrintCommand();
        String arguments = String.format("WIDTH %s", 90);
        printCommand.execute(arguments);
    }

    @Test
    public void whenExecuteIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        PrintCommand printCommand = new PrintCommand();
        boolean result = printCommand.execute("");

        // Then
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenParagraphExists_whenIsValidIsCalledWithTextOperation_thenReturnValueIsTrue() {
        // Given
        AddCommand addCommand = new AddCommand();
        String addArguments = String.format("%s \"%s\"", 29, TextUtil.getLongParagraph());
        addCommand.execute(addArguments);

        // When
        PrintCommand printCommand = new PrintCommand();
        boolean result = printCommand.execute("TEXT");

        // Then
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenParagraphExists_whenIsValidIsCalledWithWidthOperation_thenReturnValueIsTrue() {
        // Given
        AddCommand addCommand = new AddCommand();
        String addArguments = String.format("%s \"%s\"", 29, TextUtil.getLongParagraph());
        addCommand.execute(addArguments);

        // When
        PrintCommand printCommand = new PrintCommand();
        String arguments = String.format("WIDTH %s", 90);
        boolean result = printCommand.execute(arguments);

        // Then
        Assert.assertEquals(true, result);
    }

    @Test
    public void whenIsValidIsCalledWithInvalidArguments_thenReturnValueIsFalse() {
        // When
        PrintCommand printCommand = new PrintCommand();
        boolean result = printCommand.execute("");

        // Then
        Assert.assertEquals(false, result);
    }

    @Test
    public void whenIsValidIsCalledWithInvalidWidthArguments_thenReturnValueIsFalse() {
        // When
        PrintCommand printCommand = new PrintCommand();
        boolean result = printCommand.execute("WIDTH");

        // Then
        Assert.assertEquals(false, result);
    }

}
