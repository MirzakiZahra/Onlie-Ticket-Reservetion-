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
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private int plaque;
    @OneToMany
    private List<Ticket> ticketList=new ArrayList<>();



    enum VehicleType{
        TAXI,BUS
    }
}
