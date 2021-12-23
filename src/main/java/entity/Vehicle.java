package main.java.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private int plaque;
    @OneToMany
    private List<Ticket> ticketList=new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String name, VehicleType vehicleType, int plaque) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.plaque = plaque;
    }

  public   enum VehicleType{
        TAXI,BUS
    }
}
