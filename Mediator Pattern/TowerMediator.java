public interface TowerMediator {
    void shout(String announcement, Aircraft sender);
    boolean askForRunway(Aircraft requester) throws TowerBusyException;
}
