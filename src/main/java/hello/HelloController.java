package hello;

import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.nbcuni.cds.api.sdk.SeriesApiClient;

/**
 * Created by 206496764 on 8/11/2017.
 */
@RestController
public class HelloController {


    private static final String BASE_URL = "http://localhost:8080/cds-api/";

    private RestTemplate restTemplate = new RestTemplate();

    private SeriesApiClient apiClient = new SeriesApiClient(restTemplate, BASE_URL);

    public HelloController() throws URISyntaxException {
    }

    @RequestMapping("/")
    public String index(){
        return "Greetings from Spring Boot";
    }

    @RequestMapping("/series")
    public ResponseEntity getAll(){
        return apiClient.getAll();
    }

    @RequestMapping("/seriesByID")
    public ResponseEntity getByID(){
        return apiClient.getByID(1);
    }

}
