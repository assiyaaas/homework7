import java.util.Random;

public class Helicopter extends Aircraft {
    public Helicopter(String callsign, TowerMediator tower) {
        super(callsign, tower);
    }

    @Override
    public boolean tryUseRunway() {
        if (new Random().nextBoolean()) {
            System.out.println(callsign + ": Hovering over the runway, waiting.");
            return false;
        }
        return super.tryUseRunway();
    }
}
