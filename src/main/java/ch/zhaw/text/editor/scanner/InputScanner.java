package ch.zhaw.text.editor.scanner;

import java.util.Scanner;

/**
 * The input scanner is responsible for scanning the user input on the command line.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class InputScanner {

    /**
     * The {@link Scanner} object instance.
     */
    private Scanner scanner;

    /**
     * The default constructor.
     */
    public InputScanner() {
        scanner = new Scanner(System.in);
    }

    /**
     * Returns the input.
     *
     * @return The input.
     */
    public String getInput() {
        return scanner.nextLine();
    }
}
