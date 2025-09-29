package designpatterns.strategy;

public class ChatNotification implements Notification{
    @Override
    public void message() {
        System.out.println("Chat Notification");
    }
}
