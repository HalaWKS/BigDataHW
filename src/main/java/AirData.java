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

    public String getTime() {
        return time;
    }

    public String getId() {
        return id;
    }

    public int getPm25() {
        return pm25;
    }

    public int getPm10() {
        return pm10;
    }

    public int getSo2() {
        return so2;
    }

    public int getCo() {
        return co;
    }

    public int getNo2() {
        return no2;
    }

    public int getO3() {
        return o3;
    }

}