package africa.semicolon.Exceptions;

public class InvalidDetailsException extends RuntimeException {
    public InvalidDetailsException(String message) {
        super(message);
    }
}
