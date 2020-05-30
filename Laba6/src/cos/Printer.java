package cos;

public class Printer implements PrintingDevice {
    protected String name;
    private double costForOneList;
    private double speedOfPrinting;
    private double maxLoad;

    Printer(String name,double costForOneList,double speedOfPrinting,double maxLoad) {
        this.name=name;
        this.costForOneList=costForOneList;
        this.speedOfPrinting=speedOfPrinting;
        this.maxLoad=maxLoad;
    }
    @Override
    public double getCostForOneList() {

        return costForOneList;
    }

    @Override
    public double getMaxLoad() {

        return maxLoad;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSpeedOfPrinting() {
        return speedOfPrinting;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "name='" + name + '\'' +
                ", costForOneList=" + costForOneList +
                ", speedOfPrinting=" + speedOfPrinting +
                ", maxLoad=" + maxLoad +
                '}';
    }
}
