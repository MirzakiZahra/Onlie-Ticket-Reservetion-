package main.java.dto;

import main.java.dao.CityService;
import main.java.dao.TicketService;
import main.java.dao.UserService;
import main.java.dao.VehicelService;
import main.java.entity.City;
import main.java.entity.Ticket;
import main.java.entity.User;
import main.java.entity.Vehicle;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manegement {
    TicketService ticketService = new TicketService();
    UserService userService = new UserService();
    CityService cityService=new CityService();
    VehicelService vehicelService=new VehicelService();
    List<Ticket> soldTicket = new ArrayList<>();

    public void reservation(int barcode, int nationalCode) {
        Ticket ticket = ticketService.findTicket(barcode);
        User user = userService.findUser(nationalCode);
        int temp = ticket.getCount() - 1;
        ticket.setCount(temp);
        user.getTicketList().add(ticket);
        ticket.setUser(user);
        ticketService.updateTicket(ticket);
        userService.updateUser(user);
        this.soldTicket.add(ticket);
    }
    public void createUser(String firstName,String lastName,int nationalCode){
        User user=new User(firstName,lastName,nationalCode);
        userService.addUser(user);
    }
    public void createTicket(int count, int barcode, Date time, String originCityName,
                             String destinationCityName, int plaque){
        Vehicle vehicle=vehicelService.findVehicel(plaque);
        City originCity= cityService.findCity(originCityName);
        City destinationCity=cityService.findCity(destinationCityName);
        Ticket ticket=new Ticket(count,barcode,time,originCity,destinationCity,vehicle);
        ticketService.addTicketByManager(ticket);


    }
    public void createCity(String name,  int length,int width){
        City city=new City(name,length,width);
        cityService.addCityByManager(city);

    }

}
