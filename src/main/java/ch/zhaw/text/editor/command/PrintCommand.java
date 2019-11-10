package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.context.PrintContext;
import ch.zhaw.text.editor.processor.PrintProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The add command class represents the command to add paragraphs to the storage.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class PrintCommand {

    /**
     * The {@link PrintProcessor} object instance.
     */
    private PrintProcessor printProcessor;

    /**
     * Creates an {@link PrintCommand} object instance.
     */
    public PrintCommand() {
        printProcessor = new PrintProcessor();
    }

    /**
     * Returns the name of the command.
     *
     * @return A string containing the name of the command.
     */
    public String getName() {
        return "print";
    }

    /**
     * Returns the description of the command.
     *
     * @return The description of the command.
     */
    public String getDescription() {
        return "Prints text to the console.";
    }

    /**
     * Returns the help text of the command.
     *
     * @return The help text of the command.
     */
    public String getHelpText() {
        return "PRINT [TEXT|WIDTH] [width_value] This command prints text to the console.";
    }

    /**
     * Executes the command.
     *
     * @param arguments The command arguments.
     * @return A boolean state containing information about whether the operation was successful or not.
     */
    public boolean execute(String arguments) {
        if(!isValid(arguments)) {
            return false;
        }

        Pattern pattern = Pattern.compile(getRegularExpression(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(arguments);
        PrintContext context = new PrintContext();

        while(matcher.find()) {
            String firstMatch = matcher.group(1).toUpperCase();
            PrintContext.Operation operation = (firstMatch.startsWith("TEXT")) ? PrintContext.Operation.TEXT : PrintContext.Operation.WIDTH;
            context.setOperation(operation);

            if(matcher.groupCount() >= 2 && matcher.group(2) != null) {
                context.setWidth(Integer.parseInt(matcher.group(2)));
            }
        }

        return printProcessor.execute(context);
    }

    /**
     * Checks if the given {@code context} is valid.
     *
     * @param arguments The command arguments.
     * @return A boolean state containing information about whether the given context is valid or not.
     */
    public boolean isValid(String arguments) {
        return arguments.matches(getRegularExpression());
    }

    /**
     * Returns the regular expression for the command.
     *
     * @return The regular expression for the command.
     */
    private String getRegularExpression() {
        return "^(TEXT|WIDTH\\s+(\\d+))$";
    }

}
