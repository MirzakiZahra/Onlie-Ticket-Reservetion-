package main.java.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int length;
    private int width;
    @OneToMany
    private List<main.java.entity.Ticket> ticket;
    public City() {
    }

    public City(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }
}
