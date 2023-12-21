//manages all participants with the messaging interface

import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements Mediator {
    private List<Colleague> colleagues;

    public ChatMediator() {
        this.colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
        colleague.setMediator(this);
    }

    @Override
    public void sendMessage(String message, Colleague originator) {
        for (Colleague colleague : colleagues) {
            if (colleague != originator) {
                colleague.receiveMessage(message);
            }
        }
    }
}
