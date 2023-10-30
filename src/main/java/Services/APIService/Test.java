package Services.APIService;

import java.util.Arrays;

import java.util.Timer;

public class Test {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.notificationManager(() -> System.out.println("Hello"),"16:02");
        System.out.println("\nВведіть час у форматі HH:MM на який буде приходити оповіщення: ".length());
    }
}
