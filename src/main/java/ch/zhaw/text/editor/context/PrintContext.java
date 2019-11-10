package ch.zhaw.text.editor.context;

/**
 * The add context class is responsible for holding information about an add operation.
 *
 * @author Patrick Egli
 * @version 1.0.0
 */
public class PrintContext {

    /**
     * The enumeration of all available print operations.
     */
    public enum Operation {
        TEXT,
        WIDTH
    }

    private Operation operation;

    /**
     * The width of the output. This is only relevant if the operation is set to WIDTH.
     */
    private int width;

    /**
     * The default constructor.
     */
    public PrintContext() {
    }

    /**
     * Creates a {@link PrintContext} object instance with the given {@code operation} and {@code width}.
     *
     * @param operation The operation that is being set.
     */
    public PrintContext(Operation operation) {
        this(operation, 0);
    }

    /**
     * Creates a {@link PrintContext} object instance with the given {@code operation} and {@code width}.
     *
     * @param operation The operation that is being set.
     * @param width The width that is being set.
     */
    public PrintContext(Operation operation, int width) {
        this.operation = operation;
        this.width = width;
    }

    /**
     * Returns the operation.
     *
     * @return The operation.
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Sets the operation.
     *
     * @param operation The operation that is being set.
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * Returns the width.
     *
     * @return The width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the height.
     *
     * @param width The height that is being set.
     */
    public void setWidth(int width) {
        this.width = width;
    }
}
