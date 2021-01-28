import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.HTTPServer;

import java.io.IOException;

public class CustomExporter {
    public static void main(String[] args) throws IOException, InterruptedException {
        HTTPServer server = new HTTPServer(8888);
        while (true){
            doCount();
            Thread.sleep(1000);
        }
    }


    public final static Gauge httpRequestsTotal = Gauge.build()
            .name("testA")
            .help("测试")
            .labelNames("tag1", "tag2")
            .register();

    public  static void doCount() {
        //增加
        httpRequestsTotal.labels("a", "b").set(System.currentTimeMillis());

    }
}
