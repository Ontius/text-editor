package ch.zhaw.text.editor.command;

import ch.zhaw.text.editor.storage.Storage;
import org.junit.Before;
import org.junit.Test;

public class CommandManagerUnitTest {

    /**
     * Clears the storage before every test.
     */
    @Before
    public void setUp() {
        Storage.getInstance().clear();
    }

    @Test
    public void whenExecuteContainsValidInput_thenNoExceptions() {
        CommandManager commandManager = new CommandManager();

        commandManager.execute("add 12 \"Hello World\"");
    }

    @Test(expected = RuntimeException.class)
    public void whenExecuteContainsInValidInput_thenExceptionIsThrown() {
        CommandManager commandManager = new CommandManager();

        commandManager.execute("non-existing-command Hello World");
    }

}
