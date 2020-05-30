import java.util.Date;

public class HelpServicePublicTransport{        //класс "Cправочная Cлужба Oбщественного Tранспорта"

    public static class transport{ //вложенный клас "Транспорт"

        Date departure_time;
        Date time_of_arrival;
        double price;
        String lineOfWay;

        transport() {
            this.departure_time=new Date(2000, 11, 21);
            this.time_of_arrival=new Date(2450, 01, 14);
            this.price=23;
            this.lineOfWay="To the victory";
        }

        public transport(Date departure_time, Date time_of_arrival,String lineOfWay, double price){
            this.departure_time = departure_time;
            this.time_of_arrival = time_of_arrival;
            this.lineOfWay=lineOfWay;
            this.price = price;
        }

        public Date getDeparture_time() {
            return departure_time;
        }

        public Date getTime_of_arrival() {
            return time_of_arrival;
        }

        public double getPrice() {
            return price;
        }

        public String getLineOfWay() {
            return lineOfWay;
        }

        @Override
        public String toString() {
            return "transport{" +
                    "departure_time=" + departure_time +
                    ", time_of_arrival=" + time_of_arrival +
                    ", price=" + price +
                    ", lineOfWay='" + lineOfWay + '\'' +
                    '}';
        }
    }

    public class transportInter{ //внутренний клас "Транспорт"

        Date departure_time;
        Date time_of_arrival;
        double price;
        String lineOfWay;

        transportInter() {
            this.departure_time=new Date(2000, 11, 21);
            this.time_of_arrival=new Date(2450, 01, 14);
            this.price=23;
            this.lineOfWay="To the victory";
        }

        public transportInter(Date departure_time, Date time_of_arrival,String lineOfWay, double price){
            this.departure_time = departure_time;
            this.time_of_arrival = time_of_arrival;
            this.lineOfWay=lineOfWay;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getLineOfWay() {
            return lineOfWay;
        }

        public Date getTime_of_arrival() {
            return time_of_arrival;
        }

        public Date getDeparture_time() {
            return departure_time;
        }

        @Override
        public String toString() {
            return "transport{" +
                    "departure_time=" + departure_time +
                    ", time_of_arrival=" + time_of_arrival +
                    ", price=" + price +
                    ", lineOfWay='" + lineOfWay + '\'' +
                    '}';
        }
    }

    void anonym(){
        metro=new transport();
        bus=new transport();
        train=new transport();
    }


    private transport metro=new transport(new Date(2000, 11, 21),new Date(2000, 11, 21),"dghdjrg",176);
    private transport bus=new transport(new Date(2000, 11, 21), new Date(2000, 11, 21), "dghdjrg",103);
    private transport train=new transport(new Date(2000, 11, 21), new Date(2000, 11, 21),"dghdjrg", 181);
    private transportInter plain=new transportInter(new Date(2000, 11, 21), new Date(2000, 11, 21),"dghdjrg", 181);

    @Override
    public String toString() {
        return "HelpServicePublicTransport{" +
                "metro=" + metro +
                ", bus=" + bus +
                ", train=" + train +
                ", plain=" + plain +
                '}'+"объект,состоящий из объектов вложенного и внутреннего класса";
    }

    public static void main(String args[]) {

        HelpServicePublicTransport obj1 = new HelpServicePublicTransport();//объект,состоящий из объектов вложенного и внутреннего класс
        System.out.println(obj1.toString());
        HelpServicePublicTransport obj2 = new HelpServicePublicTransport(){

            private transport metro=new transport(new Date(2000, 11, 21),new Date(2000, 11, 21),"dghdjrg",176);
            private transport bus=new transport(new Date(2000, 11, 21), new Date(2000, 11, 21), "dghdjrg",103);
            private transport train=new transport(new Date(2000, 11, 21), new Date(2000, 11, 21),"dghdjrg", 181);
            private transportInter plain=new transportInter(new Date(2000, 11, 21), new Date(2000, 11, 21),"dghdjrg", 181);


            @Override
            public String toString() {
                return "HelpServicePublicTransport{" +
                        "metro=" + metro +
                        ", bus=" + bus +
                        ", train=" + train +
                        ", plain=" + plain + "}"+"Это объект анонимного класса с переопределённым методом toString";

            }
        };
        System.out.println(obj2.toString());

    }
}