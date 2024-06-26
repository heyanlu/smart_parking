package edu.northeastern.sv.khoury.smartPark.model;

/**
 * Class to calculate the parking fee
 */
public class ParkingFeeCalculator {

  /**
   * Calculates the parking fee for each vehicle type based on parking rate, parking time and vehicle type.
   * Additionally, it establishes a maximum daily payment for each vehicle type.
   *
   * @param minutes       The number of minutes parked.
   * @param parkingRate   The parking rate per hour for the vehicle type.
   * @param vehicleType   The type of the vehicle (edu.northeastern.sv.khoury.smartPark.model.Car, edu.northeastern.sv.khoury.smartPark.model.Motorbike, edu.northeastern.sv.khoury.smartPark.model.Truck).
   * @return The calculated parking fee.
   */
  public static float calculateParkingFee(float minutes, float parkingRate, VehicleType vehicleType) {
    float parkingFee;
    float withoutDiscount = (float) ((Math.ceil(minutes / 60.0)) * parkingRate);

    if (withoutDiscount > 30.0 && vehicleType == VehicleType.CAR) {
      if (minutes > 1440) {
        double days = Math.floor(minutes / 1440);
        double remainMinutes = minutes - days * 1440;
        float remainParkingFee = (float) (Math.ceil(remainMinutes / 60.0)) * parkingRate;
        if (remainParkingFee > 30.0) {
          parkingFee = (float) ((float) (days + 1.0) * 30.0);
        } else {
          parkingFee = (float) (days * 30.0 + remainParkingFee);
        }
      } else {
        parkingFee = 30.0F;
      }
    } else if (withoutDiscount > 50.0 && vehicleType == VehicleType.TRUCK) {
      if (minutes > 1440) {
        double days = Math.floor(minutes / 1440);
        double remainMinutes = minutes - days * 1440;
        float remainParkingFee = (float) (Math.ceil(remainMinutes / 60.0)) * parkingRate;
        if (remainParkingFee > 50.0) {
          parkingFee = (float) ((float) (days + 1.0) * 50.0);
        } else {
          parkingFee = (float) (days * 50.0 + remainParkingFee);
        }
      } else {
        parkingFee = 50.0F;
      }
    } else if (withoutDiscount > 15.0 && vehicleType == VehicleType.MOTORBIKE) {
      if (minutes > 1440) {
        double days = Math.floor(minutes / 1440);
        double remainMinutes = minutes - days * 1440;
        float remainParkingFee = (float) (Math.ceil(remainMinutes / 60.0)) * parkingRate;
        if (remainParkingFee > 15.0) {
          parkingFee = (float) ((float) (days + 1.0) * 15.0);
        } else {
          parkingFee = (float) (days * 15.0 + remainParkingFee);
        }
      } else {
        parkingFee = 15.0F;
      }
    } else {
      parkingFee = withoutDiscount;
    }

    return parkingFee;
  }

}