package africa.semicolon.Exceptions;

public class InvalidPasswordSizeException extends RuntimeException{
    public InvalidPasswordSizeException(String message){
        super(message);
    }

}
