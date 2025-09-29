package designpatterns.strategy;

public class EmailNotification implements Notification {

    @Override
    public void message() {
        System.out.println("Email Notification");
    }
}
