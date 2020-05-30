package cos;

public class LaserPrinter extends Printer {
    private String subtype="Это лазерный принтер";
    LaserPrinter(String name, double costForOneList, double speedOfPrinting, double maxLoad) {
        super(name, costForOneList, speedOfPrinting, maxLoad);
    }

    @Override
    public String toString() {
        return  "Тип: " + subtype + "\n" +
                "имя: " + name + "\n" +
                "Цена за один лист: " + getCostForOneList() + "\n" +
                "Скорость печати: " + getSpeedOfPrinting() + "\n" +
                "Максимальная нагрузка: " + getMaxLoad() + "\n" +
                "_______________________________________________________";
    }
}
