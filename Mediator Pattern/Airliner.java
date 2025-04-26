import java.util.Random;

public class Airliner extends Aircraft {
    private int passengers;

    public Airliner(String callsign, TowerMediator tower) {
        super(callsign, tower);
        this.passengers = 100 + new Random().nextInt(200);
    }

    @Override
    public void hear(String message) {
        super.hear(message);
        if (message.contains("I authorize the use of the band")) {
            System.out.println(callsign + ": Passengers are preparing for boarding/takeoff.");
        }
    }
}
