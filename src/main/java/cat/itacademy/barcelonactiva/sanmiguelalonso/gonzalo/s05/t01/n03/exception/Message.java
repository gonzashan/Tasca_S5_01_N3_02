package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n03.exception;

public abstract class Message {

    private String message;
    // Constructor
    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
