//contains the required methods for all classes that will facilitate communication

public interface Colleague {
    void setMediator(Mediator mediator);
    void receiveMessage(String message);
    void sendMessage(String message);
}
