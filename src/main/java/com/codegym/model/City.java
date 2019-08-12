package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float area;
    private long population;
    private float GDP;
    private String description;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(String name, float area, long population, float GDP, String description, Country country) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
        this.country = country;
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

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public float getGDP() {
        return GDP;
    }

    public void setGDP(float GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
