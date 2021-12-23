package main.java.dto;

import main.java.dao.TicketService;
import main.java.dao.UserService;
import main.java.entity.Ticket;
import main.java.entity.User;

public class Manegement {
    TicketService ticketService = new TicketService();
    UserService userService = new UserService();

    public void reservation(int barcode, int nationalCode) {
        Ticket ticket = ticketService.findTicket(barcode);
        User user = userService.findUser(nationalCode);
        int temp = ticket.getCount() - 1;
        ticket.setCount(temp);
        user.getTicketList().add(ticket);
        ticket.setUser(user);
        ticketService.updateTicket(ticket);
        userService.updateUser(user);

    }
    public void createUser(String firstName,String lastName,int nationalCode){
        User user=new User(firstName,lastName,nationalCode);
        userService.addUser(user);
    }
}
