package com.example.tdd.repository;

import com.example.tdd.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByName_returnsCarDetails() throws Exception{
        //isso não grava no database, somente no cache
        //Car savedCar = new Car(1L, "prius", "hybrid");
        //repository.save(savedCar);

        Car savedCar = entityManager.persistFlushFind(new Car(1L, "prius", "hybrid"));
        Car car = repository.findByName("prius");

        assertThat(car.getName()).isEqualTo(savedCar.getName());
        assertThat(car.getType()).isEqualTo(savedCar.getType());
    }

}