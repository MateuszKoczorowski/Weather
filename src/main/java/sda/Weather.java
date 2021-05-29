package sda;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameLocation;
    private double x;
    private double y;
    private String region;
    private String country;
    @JsonIgnore
    private Instant createDate;

    public Weather(){
    }

    public Weather(Long id, String nameLocation, double x, double y, String region, String country) {
        this.id = id;
        this.nameLocation = nameLocation;
        this.x = x;
        this.y = y;
        this.region = region;
        this.country = country;
    }

    public Weather(Long id, String nameLocation, double x, double y, String region, String country, Instant createDate) {
        this.id = id;
        this.nameLocation = nameLocation;
        this.x = x;
        this.y = y;
        this.region = region;
        this.country = country;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void  setCreateDate(Instant createDate){this.createDate = createDate;}
}

