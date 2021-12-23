package main.java.entity;

import jdk.jfr.Timestamp;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int count;
    private int barcode;
    @Timestamp
    private Date dispatchTime;
    @ManyToOne
    private main.java.entity.User user;
    @ManyToOne
    private City originCity;
    @ManyToOne
    private City destinationCity;
    @ManyToOne
    private Vehicle vehicle;

    public Ticket() {
    }

    public Ticket(int count, int barcode, Date dispatchTime, City originCity, City destinationCity, Vehicle vehicle) {
        this.count = count;
        this.barcode = barcode;
        this.dispatchTime = dispatchTime;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.vehicle = vehicle;
    }
}
