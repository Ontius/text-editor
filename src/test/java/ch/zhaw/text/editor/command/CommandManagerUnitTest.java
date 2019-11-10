package ch.zhaw.text.editor.command;

import org.junit.Test;

public class CommandManagerUnitTest {

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
