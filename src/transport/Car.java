package transport;

import java.time.LocalDate;

public class Car {

    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;
    private String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int numberOfSeats;
    private boolean winterTires;
    private final Key key;

    private final Insurance insurance;


    public Car(String brand, String model, double engineVolume, String color, int year,
               String country, String transmission, String bodyType, String registrationNumber,
               int numberOfSeats, boolean winterTires, Key key, Insurance insurance) {
        this.brand = ValidationUtils.validOrDefault(brand, "default");
        this.model = ValidationUtils.validOrDefault(model, "default");
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        this.color = ValidationUtils.validOrDefault(color, "белый");
        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }
        this.country = ValidationUtils.validOrDefault(country, "default");
        this.transmission = ValidationUtils.validOrDefault(transmission, "default");
        this.bodyType = ValidationUtils.validOrDefault(bodyType, "default");
        this.registrationNumber = ValidationUtils.validOrDefault(registrationNumber, "default");
        if (year <= 0) {
            this.numberOfSeats = 1;
        } else {
            this.numberOfSeats = numberOfSeats;
        }
        this.winterTires = winterTires;
        this.key = key;
        this.insurance = insurance;

    }

    public void setSeasonTires() {
        int currentMonth = LocalDate.now().getMonthValue();
        this.winterTires = currentMonth <= 4 || currentMonth >= 11;
    }

    public boolean isRegistrationNumberValid() {
        if (this.registrationNumber.length() != 9) {
            return false;
        }
        char[] registrationNumberCars = this.registrationNumber.toCharArray();
        return isNumberLetter(registrationNumberCars[0])
                && isNumber(registrationNumberCars[1])
                && isNumber(registrationNumberCars[2])
                && isNumber(registrationNumberCars[3])
                && isNumberLetter(registrationNumberCars[4])
                && isNumberLetter(registrationNumberCars[5])
                && isNumber(registrationNumberCars[6])
                && isNumber(registrationNumberCars[7])
                && isNumber(registrationNumberCars[8]);
    }

    private boolean isNumber(char symbol) {
        return Character.isDigit(symbol);
    }

    private boolean isNumberLetter(char symbol) {
        String allowedSymbol = "АВЕКМНОРСТУХ";
        return allowedSymbol.contains("" + symbol);
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean getWinterTires() {
        return winterTires;
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

    public String getBodyType() {
        return bodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isWinterTires() {
        return winterTires;
    }

    public Key getKey() {
        return key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    @Override
    public String toString() {
        return brand + '\'' + model + ", " +
                year + " года выпуска, " +
                " сборка в " + country + ", " +
                color + " цвет кузова, " +
                "объем двигателя - " + engineVolume +
                ", коробка передач " + transmission +
                ", тип кузова " + bodyType +
                ", регистрационный номер " + registrationNumber +
                ", количество мест - " + numberOfSeats +
                ", наличие зимней резины " + winterTires +
                ", удаленный запуск " + key.remoteEngineStart +
                ", бесключевой доступ " + key.keylessAccess +
                ", страховка действует до " + insurance.insuranceValidityPeriod +
                " р., стоимость страховки " + insurance.costOfInsurance +
                ", номер страховки " + insurance.insuranceNumber;

    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;

        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    public static class Insurance {
        private LocalDate insuranceValidityPeriod;
        private float costOfInsurance;
        private String insuranceNumber;

        public Insurance(LocalDate insuranceValidityPeriod, float costOfInsurance, String insuranceNumber) {
            this.insuranceValidityPeriod = insuranceValidityPeriod != null ? insuranceValidityPeriod : LocalDate.now().plusDays(10);
            this.costOfInsurance = Math.max(costOfInsurance, 1f);
            this.insuranceNumber = ValidationUtils.validOrDefault(insuranceNumber, "default");
        }

        public boolean insuranceNumberValid(){
            return insuranceNumber.length() == 9;
        }
        public boolean insuranceValidityPeriodValid() {
            return LocalDate.now().isBefore(this.insuranceValidityPeriod);
        }

        @Override
        public String toString() {
            return "Insurance{" +
                    "insuranceValidityPeriod=" + insuranceValidityPeriod +
                    ", costOfInsurance=" + costOfInsurance +
                    ", insuranceNumber='" + insuranceNumber + '\'' +
                    '}';
        }
    }
}
