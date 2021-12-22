package main.java.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int count;

    @ManyToOne
    private main.java.entity.User user;
    @ManyToOne
    private City originCity;
    @ManyToOne
    private City destinationCity;
}
