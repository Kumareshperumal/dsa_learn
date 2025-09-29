package designpatterns.strategy;

public class Main {
    public static void main(String[] args) {
        NotificationContext context = new NotificationContext();
        context.setStrategy(new ChatNotification());
        context.message();
        context.setStrategy(new EmailNotification());
        context.message();
    }
}
