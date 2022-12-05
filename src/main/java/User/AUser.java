package User;

import Ticket.Ticket;
import lombok.Data;

import java.util.ArrayList;

@Data
public abstract class AUser {
    private String name;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String password;
    private ArrayList<Ticket> tickets;

}
