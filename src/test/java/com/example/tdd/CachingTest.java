package com.example.tdd;

import com.example.tdd.model.Car;
import com.example.tdd.repository.CarRepository;
import com.example.tdd.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

    @Autowired
    private CarService service;

    @MockBean
    private CarRepository carRepository;

    @Test
    public void caching() throws Exception{
        given(carRepository.findByName(anyString())).willReturn(new Car(1L, "prius", "hybrid"));

        service.getCarDetails("prius");
        service.getCarDetails("prius");

        //só vai chamar 1 vez, mesmo que executado 2, pq foi salvo no cache do CarService
        verify(carRepository, times(1)).findByName("prius");
    }
}
