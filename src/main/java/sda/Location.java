package sda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.swing.plaf.synth.Region;

@Entity(name = "location")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nazwa miasta")
    private String cityName;
    @Column(name = "Szerokość geograficzna")
    private Double length;
    @Column(name = "Długość geograficzna")
    private Double longitude;
    @Column (name = "Region")
    private String region;
    @Column(name = "Kraj")
    private String country;

    public Location(Integer id, String cityName, Double length, Double longitude, String country) {
        this.id = id;
        this.cityName = cityName;
        this.length = length;
        this.longitude = longitude;
        this.country = country;
    }
}
