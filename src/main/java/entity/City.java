package entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class City {
    @Id
    private int id;
    private String name;
    private int length;
    private int width;

}
