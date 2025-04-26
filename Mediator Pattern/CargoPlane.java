import java.util.Random;

public class CargoPlane extends Aircraft {
    private String cargo;

    public CargoPlane(String callsign, TowerMediator tower) {
        super(callsign, tower);
        String[] cargos = {"auto parts", "electronics", "perishable goods"};
        this.cargo = cargos[new Random().nextInt(cargos.length)];
    }

    @Override
    public void hear(String message) {
        if (message.contains("MAYDAY")) {
            System.out.println(callsign + ": Срочная доставка груза подождёт!");
        } else {
            super.hear(message);
        }
    }
}
