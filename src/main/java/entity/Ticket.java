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

}
