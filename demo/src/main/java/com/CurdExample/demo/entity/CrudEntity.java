package com.CurdExample.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CrudEntity {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CrudEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public CrudEntity() {
        super();
    }

    public CrudEntity(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
