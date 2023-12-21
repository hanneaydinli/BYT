//represents a user in the chat application

public class User implements Colleague {
    private Mediator mediator;
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(username + " received: " + message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(username + " sends: " + message);
        mediator.sendMessage(message, this);
    }
}
