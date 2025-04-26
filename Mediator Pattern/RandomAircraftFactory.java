import java.util.Random;

public class RandomAircraftFactory {
    private static final Random RNG = new Random();

    public static Aircraft createRandomAircraft(String callsign, TowerMediator tower) {
        int type = RNG.nextInt(3);
        switch (type) {
            case 0: return new Airliner(callsign, tower);
            case 1: return new CargoPlane(callsign, tower);
            default: return new Helicopter(callsign, tower);
        }
    }
}
