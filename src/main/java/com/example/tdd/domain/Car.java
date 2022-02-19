package com.example.tdd.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Car {

    @Id
    private Long id;

    private String name;

    private String type;

    public Car(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
