package it.unicam.cs.pa.pacal;

public class UnknownCommandException extends Exception {

    private final String command;

    public UnknownCommandException(String command) {
        super("Unknown command: "+command);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}
