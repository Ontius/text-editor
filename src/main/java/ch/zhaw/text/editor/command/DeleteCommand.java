package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.context.DeleteContext;
import ch.zhaw.text.editor.processor.DeleteProcessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The delete command class represents the command to delete paragraphs from the storage.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class DeleteCommand {

    /**
     * The {@link DeleteProcessor} object instance.
     */
    private DeleteProcessor deleteProcessor;

    /**
     * Creates a {@link DeleteProcessor} object instance.
     */
    public DeleteCommand() {
        deleteProcessor = new DeleteProcessor();
    }

    /**
     * Returns the name of the command.
     *
     * @return A string containing the name of the command.
     */
    public String getName() {
        return "delete";
    }

    /**
     * Returns the description of the command.
     *
     * @return The description of the command.
     */
    public String getDescription() {
        return "Deletes a text from the storage.";
    }

    /**
     * Returns the help text of the command.
     *
     * @return The help text of the command.
     */
    public String getHelpText() {
        return "DELETE [paragraph_index] This command deletes a text from the editor.";
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
        DeleteContext context = new DeleteContext();

        while(matcher.find()) {
            context.setParagraphIndex(Integer.parseInt(matcher.group(1)));
        }

        return deleteProcessor.execute(context);
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
