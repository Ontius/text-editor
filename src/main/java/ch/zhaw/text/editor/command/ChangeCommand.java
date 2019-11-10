package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.context.ChangeContext;
import ch.zhaw.text.editor.processor.ChangeProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The replace command class represents the command to replace paragraphs in the storage.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class ChangeCommand {

    /**
     * The {@link ChangeProcessor} object instance.
     */
    private ChangeProcessor changeProcessor;

    /**
     * Creates a {@link ChangeCommand} object instance.
     */
    public ChangeCommand() {
        changeProcessor = new ChangeProcessor();
    }

    /**
     * Returns the name of the command.
     *
     * @return A string containing the name of the command.
     */
    public String getName() {
        return "change";
    }

    /**
     * Returns the description of the command.
     *
     * @return The description of the command.
     */
    public String getDescription() {
        return "Replaces a text by another text.";
    }

    /**
     * Returns the help text of the command.
     *
     * @return The help text of the command.
     */
    public String getHelpText() {
        return "CHANGE [paragraph_index] [\"search\"] [\"replacement\"] This command replaces a text by another text.";
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
        ChangeContext context = new ChangeContext();

        while(matcher.find()) {
            context.setParagraphIndex(Integer.parseInt(matcher.group(1)));
            context.setSearch(removeTrailingQuotes(matcher.group(2)));
            context.setReplacement(removeTrailingQuotes(matcher.group(3)));
        }

        return changeProcessor.execute(context);
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
        return "(\\d+)\\s+(\\\".*\\\")\\s+(\\\".*\\\")";
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
