package transport;

public abstract class Transport {

    protected final String brand;
    protected final String model;
    protected final int year;
    protected final String country;
    protected String color;
    protected int maxSpeed;
    protected float fuelPercentage;

    public Transport(String brand, String model, int year, String country,
                     String color, int maxSpeed) {
        this.brand = ValidationUtils.validOrDefault(brand, "default");
        this.model = ValidationUtils.validOrDefault(model, "default");
        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }
        this.country = ValidationUtils.validOrDefault(country, "default");
        this.color = ValidationUtils.validOrDefault(color, "белый");
        this.maxSpeed = Math.max(maxSpeed, 60);

    }

    public abstract void refill();

    public void setColor(String color) {
        this.color = ValidationUtils.validOrDefault(color, "белый");
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = Math.max(maxSpeed, 600);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public float getFuelPercentage() {
        return fuelPercentage;
    }

    public void setFuelPercentage(float fuelPercentage) {
        this.fuelPercentage = Math.max(fuelPercentage, 0.00f);
    }

    @Override
    public String toString() {
        return brand + ' ' + model + ", " +
                year + " года выпуска, " +
                " сборка в " + country + ", " +
                color + " цвет кузова, максимальная скорость - " + maxSpeed + ", "
                + "количество топлива - " + fuelPercentage + "%.";
    }
}
