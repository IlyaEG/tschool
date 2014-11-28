package ru.tsystems.ecare.exceptions;

/**
 * Exception that can occur in ECare System.
 */
public class ECareException extends RuntimeException {

    /**
     * UID.
     */
    private static final long serialVersionUID = 15566752341257L;

    /**
     * Error description message.
     */
    private final String message;

    /**
     * Constructor with message.
     *
     * @param newMessage Error description message
     */
    public ECareException(final String newMessage) {
        super(newMessage);
        this.message = newMessage;
    }

    /**
     * Constructor with message and throwable.
     *
     * @param newMessage Error description message
     * @param e throwable
     */
    public ECareException(final String newMessage, final Throwable e) {
        super(newMessage, e);
        this.message = newMessage;
    }

    @Override
    public final String getMessage() {
        return message;
    }
}
