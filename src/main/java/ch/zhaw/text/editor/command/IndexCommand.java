package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.context.IndexContext;
import ch.zhaw.text.editor.processor.IndexProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The add command class represents the command to add paragraphs to the storage.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class IndexCommand {

    /**
     * The {@link IndexProcessor} object instance.
     */
    private IndexProcessor indexProcessor;

    /**
     * Creates an {@link IndexCommand} object instance.
     */
    public IndexCommand() {
        indexProcessor = new IndexProcessor();
    }

    /**
     * Returns the name of the command.
     *
     * @return A string containing the name of the command.
     */
    public String getName() {
        return "index";
    }

    /**
     * Returns the description of the command.
     *
     * @return The description of the command.
     */
    public String getDescription() {
        return "Prints out an index of all words in the storage.";
    }

    /**
     * Returns the help text of the command.
     *
     * @return The help text of the command.
     */
    public String getHelpText() {
        return "INDEX [minimal_occurrence] This command prints out an index of all words in the editor.";
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
        IndexContext context = new IndexContext();

        while(matcher.find()) {
            context.setMinOccurrence(Integer.parseInt(matcher.group(1)));
        }

        return indexProcessor.execute(context);
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
        return "(\\d+)";
    }

}
