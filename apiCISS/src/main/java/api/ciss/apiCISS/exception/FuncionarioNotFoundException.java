package api.ciss.apiCISS.exception;

public class FuncionarioNotFoundException extends Exception {
    public FuncionarioNotFoundException() {
    }

    public FuncionarioNotFoundException(String message) {
        super(message);
    }

    public FuncionarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FuncionarioNotFoundException(Throwable cause) {
        super(cause);
    }

    public FuncionarioNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
