public class AirDataMonitor {

    public static void checkAbnormalData(AirData airData){
        if(airData.getPm25() >= 150){
            printAbnormalData(airData, "PM2.5|" + airData.getPm25());
        }
        if(airData.getPm10()>= 350){
            printAbnormalData(airData, "PM10|" + airData.getPm10());
        }
        if(airData.getSo2() >= 800){
            printAbnormalData(airData, "SO2|" + airData.getSo2());
        }
        if(airData.getCo() >= 60){
            printAbnormalData(airData, "CO|" + airData.getCo());
        }
        if(airData.getNo2() >= 1200){
            printAbnormalData(airData, "NO2|" + airData.getNo2());
        }
        if(airData.getO3() >= 400){
            printAbnormalData(airData, "O3|" + airData.getO3());
        }
    }

    private static void printAbnormalData(AirData airData, String abnormalData){
        System.out.println(airData.getTime() + "|" + airData.getId() + "|" + abnormalData);
    }

}
