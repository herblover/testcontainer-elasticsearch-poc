import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.Test;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

import java.io.IOException;

public class ElasticsearchTest {

    @Test
    public void esTest() throws IOException {
        ElasticsearchContainer container = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:6.4.2");
        container.start();

        RestClient client = RestClient.builder(container.getHost()).build();
        Response response = client.performRequest("GET", "/");

        container.stop();
    }
}
