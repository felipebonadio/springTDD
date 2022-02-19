package com.example.tdd;

import com.example.tdd.domain.Car;
import com.example.tdd.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CarService carService;

    @Test
    public void getCar_returnCarDetails() throws Exception{
        //arrange
        given(carService.getCarDetails(anyString())).willReturn(new Car(1L, "prius", "hybrid"));

        //act
        ResponseEntity<Car> response = restTemplate.getForEntity("/cars/prius", Car.class);

        //assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("prius");
        assertThat(response.getBody().getType()).isEqualTo("hybrid");
    }
}
