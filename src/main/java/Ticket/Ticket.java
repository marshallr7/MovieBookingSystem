package Ticket;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Ticket {
    private String dateTime;
    private String theater;
    private int id; // seat number
    private double price;
}
