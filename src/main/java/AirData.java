public class AirData {

    private String time;

    private String id;

    private int pm25;

    private int pm10;

    private int so2;

    private int co;

    private int no2;

    private int o3;

    public AirData(String time, String id, int pm25, int pm10, int so2, int co, int no2, int o3) {
        this.time = time;
        this.id = id;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.so2 = so2;
        this.co = co;
        this.no2 = no2;
        this.o3 = o3;
    }

    public void checkAbnormalData(){
        if(this.pm25 >= 150){
            printAbnormalData("PM2.5|" + this.pm25);
        }
        if(this.pm10 >= 350){
            printAbnormalData("PM10|" + this.pm10);
        }
        if(this.so2 >= 800){
            printAbnormalData("SO2|" + this.so2);
        }
        if(this.co >= 60){
            printAbnormalData("CO|" + this.co);
        }
        if(this.no2 >= 1200){
            printAbnormalData("NO2|" + this.no2);
        }
        if(this.o3 >= 400){
            printAbnormalData("O3|" + this.o3);
        }
    }

    private void printAbnormalData(String abnormalData){
        System.out.println(this.time + "|" + this.id + "|" + abnormalData);
    }

}