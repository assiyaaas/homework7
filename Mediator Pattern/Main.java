import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        List<Aircraft> aircrafts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Aircraft a = RandomAircraftFactory.createRandomAircraft("Flight" + (100 + i), tower);
            aircrafts.add(a);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            for (Aircraft aircraft : aircrafts) {
                aircraft.burnFuel();
                aircraft.tryUseRunway();
            }
            tower.nextTimeSlot();
        }, 0, 1, TimeUnit.SECONDS);
    }
}
