package cos;

public interface PrintingDevice {
    double getCostForOneList();//получить цену за один лист
    double getMaxLoad();//получить максимальную нагрузку
    String getName();//получить имя
    double getSpeedOfPrinting();//получить скорость печати
    String toString();
}
