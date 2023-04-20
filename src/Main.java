import transport.Bus;
import transport.Car;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car("Lada", "Granta", 1.7,
                "желтый", 2015, "Россия", "механическая",
                "седан", "А196АА132", 5, false, 180,
                new Car.Key(false, false),
                new Car.Insurance(LocalDate.now().plusMonths(3),
                        100f, "123456589"));;;

        System.out.println(ladaGranta);
        ladaGranta.setSeasonTires();
        System.out.println(ladaGranta);
        System.out.println(ladaGranta.isRegistrationNumberValid());
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черный",
                2020, "Германия", "автомат", "седан",
                "А777АА777", 5, true, 260,
                new Car.Key(true, true),
                new Car.Insurance(LocalDate.now().plusMonths(3),
                        100f, "123156789"));
        System.out.println(audiA8);
        Car bmvZ8 = new Car("BMW", "Z8", 3.0, "черный",
                2021, "Германии", "автомат", "седан",
                "Е123КХ196", 2, false, 270,
                new Car.Key(true, true),
                new Car.Insurance(LocalDate.now().plusMonths(3),
                        100f, "123456889"));
        System.out.println(bmvZ8);
        Car kiaSportage = new Car("Kia", "Sportage 4-го поколения", 2.4,
                "красный", 2018, "Южная Корея", "механическая",
                "внедорожник", "М241КА196", 5, true, 210,
                new Car.Key(true, false),
                new Car.Insurance(LocalDate.now().plusMonths(3),
                        100f, "123456774"));
        System.out.println(kiaSportage);
        Car hyundaiAvante = new Car("Hyundai", "Avante",
                1.6, "оранжевый", 2016, "Южная Корея", "механическая",
                "седан", "У481КХ001", 5, true, 200,
                new Car.Key(true, false),
                new Car.Insurance(LocalDate.now().plusMonths(3),
                        100f, "121434789"));
        System.out.println(hyundaiAvante);
        System.out.println(hyundaiAvante.getInsurance());
        Bus isuzuBogdanA092 = new Bus("Isuzu", "Bogdan A-092", 2014, "Япония",
                "желтый", 90);
        System.out.println(isuzuBogdanA092);
        Bus liaz5292 = new Bus("ЛиАЗ", "5292", 2022, "Россия", "синий", 110);
        Bus paz3204 = new Bus("ПАЗ", "3204", 2017, "Россия", "синий", 110);
    }

}
