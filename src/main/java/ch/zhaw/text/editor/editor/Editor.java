package ch.zhaw.text.editor.editor;

import ch.zhaw.text.editor.command.CommandManager;
import ch.zhaw.text.editor.scanner.InputScanner;

/**
 * The editor class contains the main loop for the editor.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class Editor {

    /**
     * The {@link CommandManager} object instance.
     */
    private CommandManager commandManager;

    /**
     * The {@link InputScanner} object instance.
     */
    private InputScanner inputScanner;

    /**
     * The default constructor.
     */
    public Editor() {
        commandManager = new CommandManager();
        inputScanner = new InputScanner();
    }

    /**
     * Runs the editor.
     */
    public void run() {
        while(true) {
            String userInput = inputScanner.getInput();

            try {
                commandManager.execute(userInput);
            } catch(Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

}
