package com.opitzconsulting.cloud4dev;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {

    @LocalServerPort
    private int serverPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        URI targetUrl = UriComponentsBuilder.fromUriString("http://localhost:" + serverPort).path("/greeting").queryParam("name", "Service")
                .build().toUri();

        ResponseEntity<Greeting> response = restTemplate.getForEntity(targetUrl, Greeting.class);
        assertNotNull(response);
        Greeting greeting = response.getBody();
        assertNotNull(greeting);
        assertEquals("Hello, Service!", greeting.getContent());
    }
}
