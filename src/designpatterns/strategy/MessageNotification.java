package designpatterns.strategy;

public class MessageNotification implements Notification{
    @Override
    public void message() {
        System.out.println("Message Notification");
    }
}
