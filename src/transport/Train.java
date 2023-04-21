package transport;

public class Train extends Transport {

    private float ticketPrice;
    private double travelTime;
    private String departureStation;
    private String arrivalsStation;
    private int wagonsNumber;

    private String fuelType = "Дизель";

    public Train(String brand, String model, int year, String country,
                 String color, int maxSpeed, float ticketPrice, double travelTime,
                 String departureStations, String arrivalStation, int wagonsNumber) {
        super(brand, model, year, country, color, maxSpeed);
        setTicketPrice(ticketPrice);
        setTravelTime(travelTime);
        setDepartureStation(departureStations);
        setArrivalsStation(arrivalStation);
        setWagonsNumber(wagonsNumber);
    }

    public void refill() {
        System.out.println("Заправляем поезд, топливо - " + fuelType);
    }
    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice =  Math.max(ticketPrice, 1.0f);
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = Math.max(travelTime, 00.00);
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = ValidationUtils.validOrDefault(departureStation, "default");
    }

    public String getArrivalsStation() {
        return arrivalsStation;
    }

    public void setArrivalsStation(String arrivalsStation) {
        this.arrivalsStation = ValidationUtils.validOrDefault(arrivalsStation, "default");
    }

    public int getWagonsNumber() {
        return wagonsNumber;
    }

    public void setWagonsNumber(int wagonsNumber) {
        this.wagonsNumber = Math.max(wagonsNumber, 1);
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Train{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", fuelPercentage=" + fuelPercentage +
                "ticketPrice=" + ticketPrice +
                ", travelTime=" + travelTime +
                ", departureStation='" + departureStation + '\'' +
                ", arrivalsStation='" + arrivalsStation + '\'' +
                ", wagonsNumber='" + wagonsNumber + '\'' +
                ", fuelPercentage='" + fuelPercentage + '%' + '\'' +
                '}';
    }
}
