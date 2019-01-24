public class NoMovesException extends Exception {
    public NoMovesException() {
        super("There is no moves left.");
    }
}
