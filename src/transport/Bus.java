package transport;

public class Bus extends Transport {

    private String fuelType;

    public Bus(String brand, String model, int year, String country,
               String color, int maxSpeed) {
        super(brand, model, year, country, color, maxSpeed);
    }
    public void refill() {
        System.out.println("Заправляем автомобиль, топливо - " + fuelType);
    }
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        if ("Дизель".contains(fuelType)) {
            this.fuelType = "Дизель";
        } else {
            this.fuelType = "Бензин";
        }
    }
}
