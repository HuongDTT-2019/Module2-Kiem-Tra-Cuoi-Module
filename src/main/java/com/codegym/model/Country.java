package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Country.class)
    private List<City> cities;

    public Country() {
    }

    public Country(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
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
}
