import java.time.LocalDateTime;

/**
 * Class representing a truck, extending AbstractVehicle.
 */
public class Truck extends AbstractVehicle{

    /**
     * Constructs a Truck object with the given parameters.
     *
     * @param licensePlate The license plate of the truck.
     * @param type         The type of the truck.
     * @param arrivalTime  The arrival time of the truck.
     * @param membershipSystem The membership system used for membership checks.
     */
    public Truck(String licensePlate, VehicleType type, LocalDateTime arrivalTime, MembershipSystem membershipSystem) {
        super(licensePlate, type, arrivalTime, membershipSystem);
    }

    /**
     * Retrieves the type of the truck.
     *
     * @return The type of the truck, which is VehicleType.TRUCK.
     */
    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }


}
