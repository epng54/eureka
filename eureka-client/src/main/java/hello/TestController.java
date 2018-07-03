package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by hanruikai on 2018/7/3.
 */


@RestController
@RequestMapping("/api/v1/")
class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("testinvoke")
    public List<ServiceInstance> serviceInstancesByApplicationName() {
        restTemplate.exchange("http://SERVICE-PROVIDER/test",HttpMethod.GET,null,String.class);
        return null;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
