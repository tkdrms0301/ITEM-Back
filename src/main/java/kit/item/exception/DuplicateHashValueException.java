package kit.item.exception;

public class DuplicateHashValueException extends RuntimeException{
    public DuplicateHashValueException() {
        super();
    }

    public DuplicateHashValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateHashValueException(String message) {
        super(message);
    }

    public DuplicateHashValueException(Throwable cause) {
        super(cause);
    }
}
