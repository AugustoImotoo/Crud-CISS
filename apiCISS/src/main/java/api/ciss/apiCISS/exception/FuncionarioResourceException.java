package api.ciss.apiCISS.exception;

public class FuncionarioResourceException extends Exception {

    public FuncionarioResourceException() {
        super();
    }

    public FuncionarioResourceException(String message) {
        super(message);
    }

    public FuncionarioResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FuncionarioResourceException(Throwable cause) {
        super(cause);
    }

    public FuncionarioResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
