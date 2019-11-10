package ch.zhaw.text.editor.command;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The command manager class is responsible to execute the individual commands.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class CommandManager {

    /**
     * A set containing all commands.
     */
    private Set commands;

    /**
     * Creates a {@link CommandManager} object instance with all ch.zhaw.text.editor.command instances.
     */
    public CommandManager() {
        commands = new HashSet(Arrays.asList(
                new AddCommand(),
                new ChangeCommand(),
                new DeleteCommand(),
                new PrintCommand(),
                new IndexCommand()
        ));
    }

    /**
     * Tries to find the ch.zhaw.text.editor.command in the input string. If a ch.zhaw.text.editor.command was found it will be returned.
     *
     * @param input The user input.
     * @return The ch.zhaw.text.editor.command object instance that was being found.
     * @throws RuntimeException If the given input is invalid.
     */
    public void execute(String input) {
        String[] parts = input.split(" ", 2);

        if(parts.length < 1) {
            String message = String.format("The given input '%s' is not valid.", input);
            throw new RuntimeException(message);
        }

        String commandName = parts[0];
        String arguments = (parts.length >= 2) ? parts[1] : "";

        if(!executeCommand(commandName, arguments)) {
            String message = String.format("Executing the command '%s' has failed. To get more information about the command use the help command.", input);
            throw new RuntimeException(message);
        }
    }

    /**
     * Returns a ch.zhaw.text.editor.command by its name.
     *
     * @param commandName The name of the command.
     * @param arguments The ch.zhaw.text.editor.command arguments.
     * @return The ch.zhaw.text.editor.command object instance that was being found.
     * @throws Exception If no command was found for the given name.
     */
    private boolean executeCommand(String commandName, String arguments) {
        String lowerCaseName = commandName.toLowerCase();

        if(lowerCaseName.equals("help")) {
            printHelp();
            return true;
        }

        for(Object command : commands) {
            if(command instanceof AddCommand) {
                AddCommand addCommand = (AddCommand) command;

                if(addCommand.getName().toLowerCase().equals(lowerCaseName)) {
                    return addCommand.execute(arguments);
                }
            } else if(command instanceof ChangeCommand) {
                ChangeCommand changeCommand = (ChangeCommand) command;

                if(changeCommand.getName().toLowerCase().equals(lowerCaseName)) {
                    return changeCommand.execute(arguments);
                }
            } else if(command instanceof DeleteCommand) {
                DeleteCommand deleteCommand = (DeleteCommand) command;

                if(deleteCommand.getName().toLowerCase().equals(lowerCaseName)) {
                    return deleteCommand.execute(arguments);
                }
            } else if(command instanceof PrintCommand) {
                PrintCommand printCommand = (PrintCommand) command;

                if(printCommand.getName().toLowerCase().equals(lowerCaseName)) {
                    return printCommand.execute(arguments);
                }
            } else if(command instanceof IndexCommand) {
                IndexCommand indexCommand = (IndexCommand) command;

                if(indexCommand.getName().toLowerCase().equals(lowerCaseName)) {
                    return indexCommand.execute(arguments);
                }
            }
        }

        throw new RuntimeException("The command with the name " + lowerCaseName + " was not found.");
    }

    /**
     * Prints all help texts.
     */
    private void printHelp() {
        for(Object command : commands) {
            if(command instanceof AddCommand) {
                AddCommand addCommand = (AddCommand) command;
                System.out.println(addCommand.getHelpText());
            } else if(command instanceof ChangeCommand) {
                ChangeCommand changeCommand = (ChangeCommand) command;
                System.out.println(changeCommand.getHelpText());
            } else if(command instanceof DeleteCommand) {
                DeleteCommand deleteCommand = (DeleteCommand) command;
                System.out.println(deleteCommand.getHelpText());
            } else if(command instanceof PrintCommand) {
                PrintCommand printCommand = (PrintCommand) command;
                System.out.println(printCommand.getHelpText());
            } else if(command instanceof IndexCommand) {
                IndexCommand indexCommand = (IndexCommand) command;
                System.out.println(indexCommand.getHelpText());
            }
        }
    }

}
