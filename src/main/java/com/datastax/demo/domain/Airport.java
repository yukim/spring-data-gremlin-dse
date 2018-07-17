package com.datastax.demo.domain;

import com.microsoft.spring.data.gremlin.annotation.Vertex;
import org.springframework.data.annotation.Id;

/**
 * "airport" vertex label.
 *
 * spring-data-gremlin assumes Class name == vertex label by default.
 * To make change, use {@code label} inside Vertex annotation.
 */
@Vertex(label = "airport")
public class Airport {
    @Id
    private String id;

    private String code;

    private String desc;

    private double lon;

    private double lat;

    private String country;

    private int longest;

    private String city;

    private int elev;

    private String icao;

    private String type;

    private String region;

    private int runways;

    public Airport() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLongest() {
        return longest;
    }

    public void setLongest(int longest) {
        this.longest = longest;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getElev() {
        return elev;
    }

    public void setElev(int elev) {
        this.elev = elev;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getRunways() {
        return runways;
    }

    public void setRunways(int runways) {
        this.runways = runways;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", country='" + country + '\'' +
                ", longest=" + longest +
                ", city='" + city + '\'' +
                ", elev=" + elev +
                ", icao='" + icao + '\'' +
                ", type='" + type + '\'' +
                ", region='" + region + '\'' +
                ", runways=" + runways +
                '}';
    }
}
