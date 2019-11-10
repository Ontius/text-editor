package ch.zhaw.text.editor;

import ch.zhaw.text.editor.editor.Editor;

/**
 * The main class is the entry point of the application.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class Main {

    /**
     * The entry point of the application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Editor editor = new Editor();

        editor.run();

        /*
        commandManager.execute("ADD 1 \"" + TextUtil.getShortParagraph() + "\"");
        commandManager.execute("ADD 2 \"" + TextUtil.getDynamicParagraph(10) + "\"");
        commandManager.execute("ADD 3 \"" + TextUtil.getShortParagraph() + "\"");
        commandManager.execute("ADD 4 \"" + TextUtil.getShortParagraph() + "\"");
        commandManager.execute("PRINT TEXT");
        commandManager.execute("PRINT WIDTH 90");

        commandManager.execute("DELETE 3");
        commandManager.execute("PRINT TEXT");

        commandManager.execute("CHANGE 1 \"fun\" \"interesting\"");
        commandManager.execute("PRINT TEXT");

        commandManager.execute("INDEX 2");
         */
    }

}
