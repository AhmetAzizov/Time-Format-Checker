public class InputFormatException extends Exception{
    public InputFormatException(String error){
        super("Error! " + error);
    }
}
