package Services.APIService;

import Services.SettingsService.Settings;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationManager{
    private Timer timer = new Timer();
    public void doNotification(final Runnable task, String t, Settings s) {
        int hours = Integer.parseInt(t.substring(0,2));
        int minutes = Integer.parseInt(t.substring(3));
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date executionTime = getTime(hours, minutes);

        System.out.println("Метод запускається о " + sdf.format(executionTime));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
                System.out.println("Метод виконується о " + sdf.format(new Date()));
            }
        }, executionTime);
    }
    private Date getTime(int hours, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date now = new Date();
        if (now.after(calendar.getTime())) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return calendar.getTime();
    }
}
