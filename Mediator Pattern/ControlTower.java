import java.util.LinkedList;
import java.util.Queue;

public class ControlTower implements TowerMediator {
    private Aircraft activeAircraft;
    private final Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeoffQueue = new LinkedList<>();

    @Override
    public void shout(String announcement, Aircraft sender) {
        System.out.println("The tower announces: " + announcement);
        if (announcement.startsWith("MAYDAY")) {
            handleEmergency(sender);
        }
    }

    @Override
    public boolean askForRunway(Aircraft requester) throws TowerBusyException {
        if (requester.isEmergency()) {
            return handleEmergencyLanding(requester);
        }

        if (activeAircraft != null) {
            throw new TowerBusyException("The runway is occupied by an airplane " + activeAircraft.getCallsign());
        }

        if (!landingQueue.isEmpty()) {
            landingQueue.add(requester);
        } else {
            takeoffQueue.add(requester);
        }

        return false;
    }

    private boolean handleEmergencyLanding(Aircraft plane) {
        System.out.println("!!! URGENT BOARDING: " + plane.getCallsign());
        if (activeAircraft != null) {
            activeAircraft.hear("Clear the lane immediately!");
        }
        activeAircraft = plane;
        return true;
    }

    private void handleEmergency(Aircraft emergencyAircraft) {
        System.out.println("Emergency mode activated! Clear the lane.");
        landingQueue.clear();
        takeoffQueue.clear();
        activeAircraft = emergencyAircraft;
    }

    public void nextTimeSlot() {
        if (activeAircraft != null) {
            System.out.println(activeAircraft.getCallsign() + " completes the operation.");
            activeAircraft = null;
        }

        if (!landingQueue.isEmpty()) {
            activeAircraft = landingQueue.poll();
        } else if (!takeoffQueue.isEmpty()) {
            activeAircraft = takeoffQueue.poll();
        }

        if (activeAircraft != null) {
            activeAircraft.hear("I authorize the use of the stripe!");
        }
    }
}
