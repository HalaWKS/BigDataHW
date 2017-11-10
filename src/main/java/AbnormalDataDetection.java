import org.apache.spark.*;
import org.apache.spark.streaming.*;
import org.apache.spark.streaming.api.java.*;

import java.util.Arrays;
import java.util.List;


public class AbnormalDataDetection {


    public void selectAbnormalData(){

        // Create a local StreamingContext with two working thread and batch interval of 1 second
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("SelectAbnormalData");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));

        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9999);
        JavaDStream<String> dataLine = lines.flatMap(x -> Arrays.asList(x.split("\\n")).iterator());

        dataLine.foreachRDD(rdd -> {
            List<String> dataList = rdd.collect();
            for (String data : dataList){
                String [] airQuality = data.split(",");
                if(data.length() > 7){
                    AirData airdata  = new AirData(
                            airQuality[0],
                            airQuality[1],
                            Integer.parseInt(airQuality[2]),
                            Integer.parseInt(airQuality[3]),
                            Integer.parseInt(airQuality[4]),
                            Integer.parseInt(airQuality[5]),
                            Integer.parseInt(airQuality[6]),
                            Integer.parseInt(airQuality[7]));
                    airdata.checkAbnormalData();
                }
            }

        });

        jssc.start();              // Start the computation
        try {
            jssc.awaitTermination();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        AbnormalDataDetection add = new AbnormalDataDetection();
        add.selectAbnormalData();
    }

}
