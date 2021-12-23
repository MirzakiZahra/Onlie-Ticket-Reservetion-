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


    }
}
