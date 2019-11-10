package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.context.AddContext;
import ch.zhaw.text.editor.processor.AddProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The add command class represents the command to add paragraphs to the storage.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class AddCommand {

    /**
     * The {@link AddProcessor} object instance.
     */
    private AddProcessor addProcessor;

    /**
     * Creates an {@link AddCommand} object instance.
     */
    public AddCommand() {
        addProcessor = new AddProcessor();
    }

    /**
     * Returns the name of the command.
     *
     * @return A string containing the name of the command.
     */
    public String getName() {
        return "add";
    }

    /**
     * Returns the description of the command.
     *
     * @return The description of the command.
     */
    public String getDescription() {
        return "Adds a text to the storage.";
    }

    /**
     * Returns the help text of the command.
     *
     * @return The help text of the command.
     */
    public String getHelpText() {
        return "ADD [paragraph_index] [\"content\"] This command adds a text to the editor.";
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

        Pattern pattern = Pattern.compile(getRegularExpression());
        Matcher matcher = pattern.matcher(arguments);
        AddContext context = new AddContext();

        while(matcher.find()) {
            context.setParagraphIndex(Integer.parseInt(matcher.group(1)));
            context.setContent(removeTrailingQuotes(matcher.group(2)));
        }

        return addProcessor.execute(context);
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
        return "(\\d+)\\s+(\\\".*\\\")";
    }

    /**
     * Removes trailing quotes from the given {@code content}.
     *
     * @param content The content that is being modified.
     * @return The modified content.
     */
    private String removeTrailingQuotes(String content) {
        if(content.startsWith("\"")) {
            content = content.substring(1);
        }

        if(content.endsWith("\"")) {
            content = content.substring(0, content.length() - 1);
        }

        return content;
    }

}
