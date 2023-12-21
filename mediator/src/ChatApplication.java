//serves as the entry point or driver class for the chat application

public class ChatApplication {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();

        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        mediator.addColleague(user1);
        mediator.addColleague(user2);
        mediator.addColleague(user3);

        user1.sendMessage("Hello, everyone!");
        user2.sendMessage("Hi, Alice!");
    }
}
