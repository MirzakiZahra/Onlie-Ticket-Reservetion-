package entity;

import entity.City;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
@Data
public class Ticket {
    @Id
    private int id;

    @ManyToOne
    private User user;
    @ManyToOne
    private City originCity;
    @ManyToOne
    private City destinationCity;
}
