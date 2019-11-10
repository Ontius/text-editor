package ch.zhaw.text.editor.processor;

import ch.zhaw.text.editor.context.PrintContext;
import ch.zhaw.text.editor.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The add processor class is responsible to add content to the storage.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class PrintProcessor {

    /**
     * The {@link Storage} object instance.
     */
    private Storage storage;

    /**
     * Creates an {@link PrintProcessor} object instance with the storage object instance.
     */
    public PrintProcessor() {
        storage = Storage.getInstance();
    }

    /**
     * Adds content to the storage.
     *
     * @param context The context holding information about the operation.
     * @return A boolean state containing information about whether the process was successful or not.
     */
    public boolean execute(PrintContext context) {

        switch(context.getOperation()) {
            case TEXT:
                printText();
                break;
            case WIDTH:
                printTextWithWidth(context.getWidth());
                break;
        }

        return true;
    }

    /**
     * Prints the whole text.
     */
    private void printText() {
        for(Map.Entry<Integer, String> entry : storage.getParagraphMap().entrySet()) {
            String paragraph = String.format("%s: %s", entry.getKey(), entry.getValue());
            System.out.println(paragraph);

            // Print out empty line to make the end of the paragraph visible.
            System.out.println();
        }
    }

    /**
     * Prints the whole text with the given {@code width}.
     *
     * @param width The width.
     */
    private void printTextWithWidth(int width) {
        for(Map.Entry<Integer, String> entry : storage.getParagraphMap().entrySet()) {
            List<String> lines = splitParagraphIntoLines(entry.getValue(), width);

            for(String line : lines) {
                System.out.println(line);
            }

            // Print out empty line to make the end of the paragraph visible.
            System.out.println();
        }
    }

    /**
     * Splits the given {@code paragraph} into lines with the given {@code width}.
     *
     * @param paragraph The paragraph that is being split.
     * @param width The width.
     * @return A list of lines.
     */
    private List<String> splitParagraphIntoLines(String paragraph, int width) {
        String rest = paragraph;
        List<String> lines = new ArrayList<>();

        while(rest.length() > 0) {
            if(rest.length() > width) {
                String line = rest.substring(0, width);
                rest = rest.substring(width);

                lines.add(line);
            } else {
                lines.add(rest);
                rest = "";
            }
        }

        return lines;
    }

}
