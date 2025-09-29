package designpatterns.strategy;

public class NotificationContext {

   private Notification strategy;

    NotificationContext(){

    }
    public void setStrategy(Notification strategy){
        this.strategy = strategy;
    }
    public void message(){
        this.strategy.message();
    }
}
