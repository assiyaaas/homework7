import java.util.Random;

public abstract class Aircraft {
    private static final Random RNG = new Random();

    protected final String callsign;
    protected int fuel;
    protected TowerMediator tower;

    public Aircraft(String callsign, TowerMediator tower) {
        this.callsign = callsign;
        this.tower = tower;
        this.fuel = RNG.nextInt(30) + 20; // 20-50% топлива
    }

    public void hear(String message) {
        System.out.printf("%s [%s]: %s\n", getClass().getSimpleName(), callsign, message);
    }

    public void yell(String message) {
        tower.shout(message, this);
    }

    public boolean tryUseRunway() {
        try {
            return tower.askForRunway(this);
        } catch (TowerBusyException e) {
            System.out.println(callsign + " received a refusal " + e.getMessage());
            return false;
        }
    }

    public void burnFuel() {
        fuel -= 5 + RNG.nextInt(10);
        if (fuel < 15 && fuel > 0) {
            yell("MAYDAY! Fuel critically low: " + fuel + "%");
        }
    }

    public boolean isEmergency() {
        return fuel < 10;
    }

    public String getCallsign() {
        return callsign;
    }
}
